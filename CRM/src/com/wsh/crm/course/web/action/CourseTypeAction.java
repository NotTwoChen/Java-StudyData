package com.wsh.crm.course.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.crm.course.domain.CrmCourseType;
import com.wsh.crm.course.service.CourseTypeService;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseTypeAction extends ActionSupport implements ServletRequestAware{
    @Autowired
    private CourseTypeService courseTypeService;
    private CrmCourseType crmCourseType;
    private HttpServletRequest request;
    private String totalStart;
    private String totalEnd;
    private String lessonCostStart;
    private String lessonCostEnd;
    private String nowPageIndex;

    public String findAll(){
        nowPageIndex = nowPageIndex == null ? "1" : nowPageIndex;
        String courseName = crmCourseType.getCourseName();
        courseName = courseName == null ? "" :courseName;
        String remark = crmCourseType.getRemark();
        remark = remark == null ? "" :remark;
        totalStart = totalStart == null ? "":totalStart;
        totalEnd = totalEnd == null ? "":totalEnd;
        lessonCostStart = lessonCostStart == null ? "":lessonCostStart;
        lessonCostEnd = lessonCostEnd == null ? "":lessonCostEnd;
        PageBean<CrmCourseType> pageBean = courseTypeService.findAll(
                Integer.parseInt(nowPageIndex),
                courseName,
                remark,
                totalStart,
                totalEnd,
                lessonCostStart,
                lessonCostEnd);
        request.setAttribute("pageBean",pageBean);
        return SUCCESS;
    }
    public String findAll2(){
        List<CrmCourseType> crmCourseTypes = courseTypeService.findAll();
        request.setAttribute("crmCourseTypes",crmCourseTypes);
        return SUCCESS+"2";
    }
    public String findByCourseTypeId(){
        crmCourseType = courseTypeService.findByCourseTypeId(crmCourseType.getCourseTypeId());
        request.setAttribute("crmCourseType",crmCourseType);
        return "find";
    }
    public String edit(){
        String courseTypeId = crmCourseType.getCourseTypeId();
        if (!courseTypeId.equals("")){
            courseTypeService.update(crmCourseType);
        }else {
            crmCourseType.setCourseTypeId(MD5_UUID_Util.getUuid());
            courseTypeService.add(crmCourseType);
        }
        return "edit";
    }
    public String findByASP(){
        List<CrmCourseType> crmCourseTypes = courseTypeService.findByASP(
                crmCourseType.getCourseName(),crmCourseType.getRemark(),
                totalStart,totalEnd,
                lessonCostStart,lessonCostEnd);
        request.setAttribute("crmCourseTypes",crmCourseTypes);
        return "asp";
    }

    public String getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(String nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public void setLessonCostStart(String lessonCostStart) {
        this.lessonCostStart = lessonCostStart;
    }

    public void setLessonCostEnd(String lessonCostEnd) {
        this.lessonCostEnd = lessonCostEnd;
    }


    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }


    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }

    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
