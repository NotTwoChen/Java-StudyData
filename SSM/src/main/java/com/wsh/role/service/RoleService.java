package com.wsh.role.service;

import com.wsh.role.domain.ModuleInfo;
import com.wsh.role.domain.RoleInfo;
import com.wsh.role.service.util.RolePageBean;

import java.util.List;

public interface RoleService {

    RolePageBean queryAllByPage(RolePageBean pageBean);

    List<ModuleInfo> queryAllModule();

    RoleInfo queryByRoleId(int role_id);

    void updateRole(RoleInfo roleInfo);

    void insertRole(RoleInfo roleInfo);

    void deleteRole(int role_id);

    List<RoleInfo> queryAllRole();
}
