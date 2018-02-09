package com.wsh.domain;

public class Items {
    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Items(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Items() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}