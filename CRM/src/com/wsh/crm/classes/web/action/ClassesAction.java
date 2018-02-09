package com.wsh.crm.classes.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.crm.classes.domain.CrmClasses;
import com.wsh.crm.classes.service.ClassesService;
import com.wsh.crm.util.MD5_UUID_Util;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Scope("prototype")
public class ClassesAction extends ActionSupport implements ServletRequestAware{
    @Autowired
    private ClassesService classesService;
    @Autowired
    private CrmClasses crmClasses;
    private HttpServletRequest request;
    private File upload;
    private String uploadFileName;
    private String uploadContentType;
    private InputStream fileStream;
    private String downloadFileName;

    public String findAll(){
        List<CrmClasses> crmClasses = classesService.findAll();
        request.setAttribute("crmClasses",crmClasses);
        return SUCCESS;
    }
    public String addOrEdit(){
        classesService.addOrEdit(crmClasses);
        return "addOrEdit";
    }
    public String findByClassId(){
        String classId = crmClasses.getClassId();
        crmClasses = classesService.findByClassId(classId);
        request.setAttribute("crmClasses",crmClasses);
        return "fbi";
    }
    public String show(){
        String classId = crmClasses.getClassId();
        crmClasses = classesService.findByClassId(classId);
        request.setAttribute("crmClasses",crmClasses);
        return "show";
    }
    public String findByClassId2(){
        String classId = crmClasses.getClassId();
        crmClasses = classesService.findByClassId(classId);
        request.setAttribute("crmClasses",crmClasses);
        return "fbi2";
    }
    public String upload() throws IOException {
        crmClasses = classesService.findByClassId(this.crmClasses.getClassId());
        crmClasses.setUploadTime(new Timestamp(new Date().getTime()));
        uploadFileName = MD5_UUID_Util.getUuid()+"." + uploadFileName.split("\\.")[1];
        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()){ file.mkdirs(); }
        FileUtils.moveFile(upload,new File(file,uploadFileName));
        crmClasses.setUploadPath("/WEB-INF/upload/"+uploadFileName);
        crmClasses.setUploadFilename("("+crmClasses.getName()+")"
                + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
                + crmClasses.getCrmCourseType().getCourseName());
        classesService.upload(crmClasses);
        return INPUT;
    }

    public String download() throws UnsupportedEncodingException {
        crmClasses = classesService.findByClassId(crmClasses.getClassId());
        fileStream = request.getServletContext().getResourceAsStream(crmClasses.getUploadPath());
        return "down";
    }

    public InputStream getFileStream() {
        return fileStream;
    }

    public void setFileStream(InputStream fileStream) {
        this.fileStream = fileStream;
    }

    public String getDownloadFileName() throws UnsupportedEncodingException {
        crmClasses = classesService.findByClassId(crmClasses.getClassId());
        downloadFileName = crmClasses.getUploadFilename()+".doc";
//        downloadFileName = URLEncoder.encode(downloadFileName,"GBK");
        return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public CrmClasses getCrmClasses() {
        return crmClasses;
    }

    public void setCrmClasses(CrmClasses crmClasses) {
        this.crmClasses = crmClasses;
    }

    public ClassesService getClassesService() {
        return classesService;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
