package com.wsh.work.service;

import com.wsh.work.bean.User;
import com.wsh.work.dao.UserDao;

public class UserService {
    private UserDao ud = new UserDao();

    public User query(int uid){
        User query = ud.query(uid);
        return query;
    }
}
