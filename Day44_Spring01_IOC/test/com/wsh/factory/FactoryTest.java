package com.wsh.factory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FactoryTest {
    private ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void staticFactory() throws Exception {
        Object staticFactory = context.getBean("staticFactory");
        System.out.println(staticFactory);
    }

    @Test
    public void fact() throws Exception {
        // 因为我们在配置文件中,已经为user3指定了工厂
        // 所以这里不需要先获得工厂在获得User对象了
        // spring已经帮我们创建好了
        Object user3 = context.getBean("user3");
        System.out.println(user3);
    }
}