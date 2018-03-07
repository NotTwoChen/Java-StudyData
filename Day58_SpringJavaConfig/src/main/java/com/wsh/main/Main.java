package com.wsh.main;

import com.wsh.config.ELConfig;
import com.wsh.config.SpringConfig;
import com.wsh.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
//        context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        HelloService helloService = context.getBean(HelloService.class);
//        HelloService helloService = (HelloService) context.getBean("helloService");
//        helloService.say();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig elConfig = context.getBean(ELConfig.class);
        elConfig.outputResource();
        context.close();
    }
}
