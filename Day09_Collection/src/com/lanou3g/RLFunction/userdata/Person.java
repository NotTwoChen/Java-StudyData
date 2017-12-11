package com.lanou3g.RLFunction.userdata;

import com.lanou3g.RLFunction.userInter.UserInter;

public class Person implements UserInter {
    private String name;
    private String username;
    private String password;
    private String work;

    public Person() {
    }

    public Person(String name, String username, String password, String work) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.work = work;
    }
    @Override
    public String toString() {
        return "①用户姓名:" + getName()+"\n"
                + "②用户职业:" + getWork();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public void onLine() {

    }

    @Override
    public void offLine() {

    }
}
