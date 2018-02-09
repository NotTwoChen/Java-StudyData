package com.wsh.ssh.dao;

import com.wsh.ssh.domain.User;
import com.wsh.ssh.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void test() throws Exception {

        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao.getClass().getName());
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getClass().getName());
        User login = userService.login(new User("123", "123"));
        System.out.println(login);
    }
}