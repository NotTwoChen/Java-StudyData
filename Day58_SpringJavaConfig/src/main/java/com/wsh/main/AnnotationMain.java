package com.wsh.main;

import com.wsh.config.MyConfig;
import com.wsh.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.output();
        context.close();
    }
}
