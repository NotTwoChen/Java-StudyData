package com.wsh.role.domain;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;

    private List<ModuleInfo> moduleInfos;

    private List<Integer> moduleIds;

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", moduleInfos=" + moduleInfos +
                ", moduleIds=" + moduleIds +
                '}';
    }

    public RoleInfo(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public List<ModuleInfo> getModuleInfos() {
        return moduleInfos;
    }

    public void setModuleInfos(List<ModuleInfo> moduleInfos) {
        this.moduleInfos = moduleInfos;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public RoleInfo() {
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