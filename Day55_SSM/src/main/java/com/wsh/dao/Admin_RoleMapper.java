package com.wsh.dao;

import com.wsh.domain.Admin_Role;

public interface Admin_RoleMapper {
    int insert(Admin_Role record);

    int insertSelective(Admin_Role record);
}