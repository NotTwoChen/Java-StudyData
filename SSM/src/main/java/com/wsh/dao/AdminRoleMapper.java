package com.wsh.dao;

import com.wsh.domain.AdminRole;

public interface AdminRoleMapper {
    int insert(AdminRole record);

    int insertSelective(AdminRole record);
}