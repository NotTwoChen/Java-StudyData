package com.wsh.study;

import java.io.Serializable;

public class Pet implements Serializable{

    private String name;
    private String gender;

    public Pet() {
    }

    public Pet(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
