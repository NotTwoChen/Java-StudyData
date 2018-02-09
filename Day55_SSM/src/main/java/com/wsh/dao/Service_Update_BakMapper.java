package com.wsh.dao;

import com.wsh.domain.Service_Update_Bak;

public interface Service_Update_BakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Service_Update_Bak record);

    int insertSelective(Service_Update_Bak record);

    Service_Update_Bak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Service_Update_Bak record);

    int updateByPrimaryKey(Service_Update_Bak record);
}