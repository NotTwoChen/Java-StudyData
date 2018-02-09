package com.wsh.dao;

import com.wsh.domain.ServiceUpdateBak;

public interface ServiceUpdateBakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceUpdateBak record);

    int insertSelective(ServiceUpdateBak record);

    ServiceUpdateBak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceUpdateBak record);

    int updateByPrimaryKey(ServiceUpdateBak record);
}