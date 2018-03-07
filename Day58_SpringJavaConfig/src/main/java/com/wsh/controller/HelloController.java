package com.wsh.controller;

import com.wsh.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

    /**
     * @RequestMapper("/pathParam/{str}") 中的str就对应方法中的str参数
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value = ("/pathParam/{str}"),produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String pathParam(@PathVariable String str, HttpServletRequest request){
        return "url:" + request.getRequestURI() + "    参数值为:" + str;
    }

    @RequestMapping(value = "/convert",produces = "application/x-wsh")
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
