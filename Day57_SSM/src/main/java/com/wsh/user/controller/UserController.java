package com.wsh.user.controller;

import com.wsh.user.dao.UserMapper;
import com.wsh.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/tor")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user){
        userMapper.insert(user);
        return "redirect:/user/login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
