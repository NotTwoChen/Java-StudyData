package com.wsh.user.dao;

import com.wsh.user.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void insert() throws Exception {
        userMapper.insert(new User(1,"我是谁"));
    }

    @Test
    public void select() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @After
    public void tearDown() throws Exception {
    }

}