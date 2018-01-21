package com.wsh.work.dao;

import com.wsh.util.HibernateUtil;
import com.wsh.work.bean.User;

public class UserDao {

    public User query(int uid){
        return HibernateUtil.handle(session -> {
            return session.get(User.class, uid);
        });
    }
}
