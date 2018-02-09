package com.wsh.controller;

import com.wsh.domain.User;
import com.wsh.domain.UserWrap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private String SUCCESS = "success";

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("---Hello SpringMVC---");
        return SUCCESS;
    }

    @RequestMapping(value = "/login")
    public String login(String username,String password){
        System.out.println("username:------" + username);
        System.out.println("password:------" + password);
        return SUCCESS;
    }

    @RequestMapping(value = "/login2")
    public String login2(User user){
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping(value = "/login3")
    public String login3(UserWrap userWrap){
        System.out.println(userWrap);
        return SUCCESS;
    }

    @RequestMapping("/login4")
    public String login4(User user, Model model){
        // 相当于application域
        model.addAttribute("user",user);
        return SUCCESS;
    }

    @RequestMapping("/updateById/{id}")
    public String updateById(@PathVariable Integer id){
        System.out.println(id);
        return SUCCESS;
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:success";
    }

    // 加/表示要访问的是控制器,而不是jsp页面
    @RequestMapping("/redirect1")
    public String redirectController(){
        return "redirect:/updateById/2";
    }

    @RequestMapping("/register")
    public @ResponseBody UserWrap register(User user){
        // 200 表示访问成功
        // SUCCESS表示提示信息
        // user才是真正的数据
        // 后端在传给前端json数据时
        // 都会遵从上述格式
            // code:响应码,如果出错,设置对应响应码
            // message:成功:success,出错:异常信息
            // user:真正的数据
        // 也就是说,只要传给前端json数据,都需要将真正的JavaBean包装
        return new UserWrap(200, SUCCESS, user);
    }
}
