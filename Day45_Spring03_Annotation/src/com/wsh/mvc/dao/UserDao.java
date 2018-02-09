package com.wsh.mvc.dao;

import com.wsh.mvc.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    public User query(){
        User user = (User) context.getBean("user");
        return user;
    }

    public static ApplicationContext getContext() {
        return context;
    }


}
