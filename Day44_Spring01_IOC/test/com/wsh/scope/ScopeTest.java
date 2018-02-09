package com.wsh.scope;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ScopeTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void lazy() throws Exception {
        context.getBean("car");
        context.getBean("car");
        context.getBean("car");
        context.getBean("car");
    }

    @Test
    public void prototype() throws Exception {
        context.getBean("student");
        context.getBean("xxx");
//        context.getBean("yyy");
        context.getBean("student2");
        context.getBean("stu,yyy");
    }
}