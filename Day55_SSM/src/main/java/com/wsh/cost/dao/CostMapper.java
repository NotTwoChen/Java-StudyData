package com.wsh.cost.dao;

import com.wsh.cost.domain.Cost;

import java.util.List;

public interface CostMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> selectAll();
}