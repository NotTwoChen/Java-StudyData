package com.wsh.study.dao;

import com.wsh.study.domain.User;

public class UserDao {

    private User user;

    public void insert(){
        System.out.println("----insert----" + ":----添加了一个User:" + user.toString());
    }

    public void setUser(User user) {
        this.user = user;
    }
}