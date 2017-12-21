package com.wsh.study;

public class User {
    private int uid;
    private String uname;
    private int age;
    private String loc;

    public User() {
    }

    public User(int uid, String uname, int age, String loc) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", loc='" + loc + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
