package com.wsh.admin.service.util;

import com.wsh.admin.domain.AdminInfo;
import com.wsh.util.PageBean;

public class AdminPageBean extends PageBean<AdminInfo>{

    private Integer moduleId;

    private String roleName;

    public AdminPageBean(int nowPageIndex, int dataCount, Integer moduleId, String roleName) {
        super(nowPageIndex, dataCount);
        this.moduleId = moduleId;
        this.roleName = roleName;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AdminPageBean() {
    }

    public AdminPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
}
