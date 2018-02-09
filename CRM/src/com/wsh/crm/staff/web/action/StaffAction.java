package com.wsh.crm.staff.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.crm.staff.domain.CrmStaff;
import com.wsh.crm.staff.service.StaffService;
import com.wsh.crm.staff.service.exception.NameOrPwdErrorException;
import com.wsh.crm.util.MD5_UUID_Util;
import com.wsh.crm.util.PageBean;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
public class StaffAction extends ActionSupport implements ServletRequestAware{
    @Autowired
    private StaffService staffService;
    private HttpServletRequest request;
    @Autowired
    private CrmStaff crmStaff;
    private String nowPageIndex;

    /**
     * 员工登录
     * @return
     */
    public String login(){
        try {
            crmStaff = staffService.login(crmStaff);
        } catch (NameOrPwdErrorException e) {
            addFieldError("login",e.getMessage());
            request.setAttribute("loginName",crmStaff.getLoginName());
            return ERROR;
        }
        request.getSession().setAttribute("crmStaff",crmStaff);
        return SUCCESS;
    }

    /**
     * 跳转到首页
     * @return
     */
    public String home(){
        return "home";
    }
    public String editPassword(){
        String oldPassword = MD5_UUID_Util.getMd5(request.getParameter("oldPassword"));
        String newPassword = MD5_UUID_Util.getMd5(request.getParameter("newPassword"));
        String reNewPassword = MD5_UUID_Util.getMd5(request.getParameter("reNewPassword"));
        CrmStaff staff = (CrmStaff) request.getSession().getAttribute("staff");
        System.out.println(oldPassword+"----"+newPassword+"----"+reNewPassword+"----"+staff.getLoginPwd());
        if (!oldPassword.equals(staff.getLoginPwd())){
            addFieldError("editPassword","原始密码错误~!");
            return INPUT;
        }else if (newPassword.equals(oldPassword)){
            addFieldError("editPassword","原始密码和新密码相同~!");
            return INPUT;
        }else if (!newPassword.equals(reNewPassword)){
            addFieldError("editPassword","两次输入的密码不一致~!");
            return INPUT;
        }else {
            staffService.editPassword(staff,newPassword);
            return LOGIN;
        }
    }
    public String logout(){
        request.getSession().setAttribute("staff",null);
        return LOGIN;
    }
    public String findAll(){
        String depId = crmStaff.getCrmPost().getCrmDepartment().getDepId();
        depId = depId == null ? "" : depId;
        String postId = crmStaff.getCrmPost().getPostId();
        postId = postId == null ? "" : postId;
        String staffName = crmStaff.getStaffName();
        staffName = staffName == null ? "" : staffName;
        if (nowPageIndex == null || nowPageIndex.equals("")){
            nowPageIndex = "1";
        }
        PageBean<CrmStaff> pageBean = staffService.queryAll(Integer.parseInt(nowPageIndex), depId, postId, staffName);
        request.setAttribute("pageBean",pageBean);
        return "list";
    }
    public String editStaff(){
        String staffId = crmStaff.getStaffId();
        CrmStaff crmStaff = staffService.queryByStaffId(staffId);
        request.setAttribute("crmStaff",crmStaff);
        return "edit";
    }
    public String updateStaff(){
        staffService.updateStaff(crmStaff);
        return "update";
    }
    public String add(){
        crmStaff.setLoginPwd(MD5_UUID_Util.getMd5(crmStaff.getLoginPwd()));
        staffService.insert(crmStaff);
        return "insert";
    }


    public String getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(String nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public CrmStaff getCrmStaff() {
        return crmStaff;
    }

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
