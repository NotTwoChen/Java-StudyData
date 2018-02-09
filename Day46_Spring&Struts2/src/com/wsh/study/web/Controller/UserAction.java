package com.wsh.study.web.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wsh.study.service.UserService;

public class UserAction extends ActionSupport {
    private UserService userService;

    public String register(){
        userService.register();
        return SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
