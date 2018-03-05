package com.wsh.role.domain;

public class ModuleInfo {
    private Integer moduleId;

    private String name;

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", name='" + name + '\'' +
                '}';
    }

    public ModuleInfo(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public ModuleInfo() {
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