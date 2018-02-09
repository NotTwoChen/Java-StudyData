package com.wsh.dao;

import com.wsh.domain.Admin_Info;

public interface Admin_InfoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin_Info record);

    int insertSelective(Admin_Info record);

    Admin_Info selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin_Info record);

    int updateByPrimaryKey(Admin_Info record);
}