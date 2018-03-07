package com.wsh.service;

// 使用@Bean形式的bean
public class BeanService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanService() {
        System.out.println("初始化构造方法-BeanService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
