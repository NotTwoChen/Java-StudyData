package com.wsh.annotation;

import org.springframework.stereotype.Controller;

@Controller
// struts2中的action
// 使用这个注解
public class LoginAction {

    public String login(){
        return "success";
    }
}
