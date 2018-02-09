package com.wsh.crm.department.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.crm.department.domain.CrmDepartment;
import com.wsh.crm.department.service.DepartmentService;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DepartmentAction extends ActionSupport implements ServletRequestAware {
    @Autowired
    private DepartmentService departmentService;
    private HttpServletRequest request;
    @Autowired
    private CrmDepartment crmDepartment;
    private String nowPageIndex;

    public String findAll(){
        List<CrmDepartment> departments = departmentService.queryAll();
        request.setAttribute("crmDepartments",departments);
        return SUCCESS;
    }
    public String findAll2(){
        List<CrmDepartment> departments = departmentService.queryAll();
        request.setAttribute("crmDepartments",departments);
        return SUCCESS+"2";
    }
    public String findAll3(){
        List<CrmDepartment> departments = departmentService.queryAll();
        request.setAttribute("crmDepartments",departments);
        return SUCCESS+"3";
    }
    public String findAll4(){
        List<CrmDepartment> departments = departmentService.queryAll();
        request.setAttribute("crmDepartments",departments);
        return SUCCESS+"4";
    }
    public String findAllDepartment(){
        nowPageIndex = nowPageIndex == null ? "1":nowPageIndex;
        PageBean<CrmDepartment> pageBean = departmentService.queryAll(Integer.parseInt(nowPageIndex));
        request.setAttribute("pageBean",pageBean);
        return "allDepartment";
    }
    public String findByDepId(){
        String depId = crmDepartment.getDepId();
        crmDepartment = departmentService.queryByDepId(depId);
        request.setAttribute("crmDepartment",crmDepartment);
        return "find";
    }
    public String edit(){
        System.out.println(crmDepartment.getDepId());
        if (crmDepartment.getDepId()!=null&&!crmDepartment.getDepId().equals("")) {
            departmentService.update(crmDepartment);
        }else {
            crmDepartment.setDepId(MD5_UUID_Util.getUuid());
            departmentService.add(crmDepartment);
        }
        return "edit";

    }

    public String getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(String nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
