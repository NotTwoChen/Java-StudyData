package com.wsh.domain;

public class DemoObj {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "DemoObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoObj(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public DemoObj() {

    }
}
