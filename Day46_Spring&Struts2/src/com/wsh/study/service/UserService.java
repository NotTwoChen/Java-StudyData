package com.wsh.study.service;

import com.wsh.study.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void register(){
        System.out.println("----service----");
        userDao.insert();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
