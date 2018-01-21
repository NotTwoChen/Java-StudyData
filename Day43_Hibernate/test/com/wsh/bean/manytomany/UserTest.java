package com.wsh.bean.manytomany;

import com.wsh.util.HibernateUtil;
import org.junit.Test;

public class UserTest {

    @Test
    public void save(){

        HibernateUtil.handle(session -> {
            User user = new User("张三");
            Role role = new Role("管理员");
            user.getRoles().add(role);
            role.getUsers().add(user);
            session.save(user);
            return null;
        });
    }

    @Test
    public void get(){
        HibernateUtil.handle(session -> {
            User user = session.get(User.class, "40289442610d811101610d8112fd0000");
            System.out.println(user.getRoles());
            System.out.println(user);
            return user;
        });
    }

}