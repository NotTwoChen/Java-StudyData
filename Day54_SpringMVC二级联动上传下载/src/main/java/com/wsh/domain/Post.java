package com.wsh.domain;

import java.util.List;

public class Post {

    private int id;
    private String name;
    private int departId;
    private List<User> users;

    public Post(int id, String name, int departId) {
        this.id = id;
        this.name = name;
        this.departId = departId;
    }

    public Post(int id, String name, int departId, List<User> users) {

        this.id = id;
        this.name = name;
        this.departId = departId;
        this.users = users;
    }

    public Post() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
