package com.wsh.domain;

public class Role_Info {
    private Integer roleId;

    private String name;

    public Role_Info(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Role_Info() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}