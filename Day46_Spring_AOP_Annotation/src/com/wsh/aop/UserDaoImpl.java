package com.wsh.aop;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
//        int a = 10/0;
        System.out.println("-----add------");
    }
    @Override
    public String get(){
        return "-----get方法已执行-----";
    }
}
