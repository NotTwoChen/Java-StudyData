package com.wsh.work.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.work.bean.User;
import com.wsh.work.service.UserService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport implements ServletRequestAware {

    private User user = new User();
    private UserService us = new UserService();
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    public String login(){
        if (!user.getUsername().equals("123")){
            addFieldError("username","账号不存在!~");
            return ERROR;
        }
        if (!user.getPassword().equals("123")){
            addFieldError("password","密码不正确!~");
            return ERROR;
        }
        request.getSession().setAttribute("user",user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
