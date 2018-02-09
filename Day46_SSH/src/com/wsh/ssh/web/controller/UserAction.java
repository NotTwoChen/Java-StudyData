package com.wsh.ssh.web.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.ssh.domain.User;
import com.wsh.ssh.service.UserService;
import com.wsh.ssh.service.exception.PasswordErrorException;
import com.wsh.ssh.service.exception.UserAlreadyExistsException;
import com.wsh.ssh.service.exception.UserExitException;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

    private User user;
    @Autowired
    private UserService userService;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public String register(){
        try {
            userService.register(user);
        } catch (UserAlreadyExistsException e) {
            addFieldError("username",e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    public String login(){
        try {
            user = userService.login(user);
        } catch (UserExitException e) {
            addFieldError("username",e.getMessage());
            return ERROR;
        } catch (PasswordErrorException e) {
            addFieldError("password",e.getMessage());
            return ERROR;
        }
        request.getSession().setAttribute("user",user);
        return SUCCESS;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        response = httpServletResponse;
    }
}
