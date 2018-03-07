package com.wsh.main;

import com.wsh.config.AwareConfig;
import com.wsh.service.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareMain {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AwareConfig.class);
        context.refresh();
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResource();
    }
}
