package com.wsh.role.domain;

public class RoleModule {
    private Integer roleId;

    private Integer moduleId;

    @Override
    public String toString() {
        return "RoleModule{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }

    public RoleModule(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    public RoleModule() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}