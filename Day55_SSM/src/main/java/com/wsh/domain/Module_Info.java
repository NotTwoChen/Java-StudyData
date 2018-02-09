package com.wsh.domain;

public class Module_Info {
    private Integer moduleId;

    private String name;

    public Module_Info(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public Module_Info() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}