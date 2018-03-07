package com.wsh.service;

import com.wsh.anno.Action;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service // 标识这是一个Service,也是Spring中的一个Bean
public class AopDemoService {

    @Value("666")
    public String name;

    @Action(name = "好好好")
    public void showAop(){

    }
}
