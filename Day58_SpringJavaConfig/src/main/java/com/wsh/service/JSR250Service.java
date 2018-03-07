package com.wsh.service;

import javax.annotation.PostConstruct;

public class JSR250Service {

    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250Service() {
        System.out.println("构造方法:JSR250Service");
    }

    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}
