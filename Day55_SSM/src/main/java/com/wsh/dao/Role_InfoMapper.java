package com.wsh.dao;

import com.wsh.domain.Role_Info;

public interface Role_InfoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role_Info record);

    int insertSelective(Role_Info record);

    Role_Info selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role_Info record);

    int updateByPrimaryKey(Role_Info record);
}