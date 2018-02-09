package com.wsh.domain;

import java.util.List;

public class Depart {

    private int id;
    private String name;
    private List<Post> posts;

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    public Depart(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Depart(int id, String name, List<Post> posts) {

        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public Depart() {

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
