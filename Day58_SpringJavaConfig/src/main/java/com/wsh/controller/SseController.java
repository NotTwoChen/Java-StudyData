package com.wsh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {


    /**
     *  若使用SSE,则需要向服务器端输出的类型为:text/event-stream
     * @return
     */
    @RequestMapping(value = "/push",produces = {"text/event-stream;charset=UTF-8"})
    @ResponseBody
    public String push(){
        Random random = new Random();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:SSE 1,2,3   "+ random.nextInt() + "\n\n";
    }
}
