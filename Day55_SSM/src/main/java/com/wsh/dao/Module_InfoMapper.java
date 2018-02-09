package com.wsh.dao;

import com.wsh.domain.Module_Info;

public interface Module_InfoMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(Module_Info record);

    int insertSelective(Module_Info record);

    Module_Info selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(Module_Info record);

    int updateByPrimaryKey(Module_Info record);
}