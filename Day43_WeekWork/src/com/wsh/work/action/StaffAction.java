package com.wsh.work.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.work.bean.Staff;
import com.wsh.work.dao.StaffDao;
import com.wsh.work.service.StaffService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StaffAction extends ActionSupport implements ServletRequestAware{
    private Staff staff = new Staff();
    private StaffService ss = new StaffService();
    private HttpServletRequest request;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
    public String queryAll(){
        List<Staff> staffs = ss.queryAll();
        request.getSession().setAttribute("staffs",staffs);
        return SUCCESS;
    }
    public String query(){
        request.getSession().setAttribute("staff",staff);
        return SUCCESS;
    }
    public String update(){
        ss.update(staff);
        return SUCCESS;
    }
    public String insert(){
        ss.save(staff);
        return SUCCESS;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
