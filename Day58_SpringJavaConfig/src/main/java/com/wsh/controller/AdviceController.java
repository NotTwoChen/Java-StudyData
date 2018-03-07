package com.wsh.controller;

import com.wsh.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg")String m, DemoObj obj){
        System.out.println(obj);
        throw new IllegalArgumentException("非常抱歉,参数有误/"+"来自@ModelAttribute:"+m);
    }
}
