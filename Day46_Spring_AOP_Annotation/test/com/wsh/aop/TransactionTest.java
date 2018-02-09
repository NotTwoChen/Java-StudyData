package com.wsh.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void aop() throws Exception {

        UserDao userDao = (UserDao) context.getBean("userDao");

        userDao.add();


        String s = userDao.get();
        System.out.println(s);

    }
}