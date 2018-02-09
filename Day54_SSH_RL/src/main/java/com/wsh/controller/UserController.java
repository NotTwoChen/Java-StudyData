package com.wsh.controller;

import com.wsh.domain.User;
import com.wsh.service.UserService;
import com.wsh.service.exception.UserAlreadyExistException;
import com.wsh.service.exception.UserException;
import com.wsh.service.exception.UserInexistenceException;
import com.wsh.service.exception.UserMismatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping("/register")
    public String register(User form, Model model){
        try {
            userService.register(form);
        } catch (UserException e) {
            model.addAttribute("msg",e.getMessage());
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login(User form,Model model){
        try {
            userService.login(form);
        } catch (UserException e) {
            model.addAttribute("msg",e.getMessage());
            return "login";
        }
        model.addAttribute("user",form);
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        model.addAttribute("user",null);
        return "login";
    }

    @RequestMapping("/cancel")
    public String cancel(User form,Model model){
        userService.cancel(form);
        return logout(model);
    }


    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
