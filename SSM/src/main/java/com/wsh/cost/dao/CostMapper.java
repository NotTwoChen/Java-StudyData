package com.wsh.cost.dao;

import com.wsh.cost.domain.Cost;
import com.wsh.util.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CostMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> selectAll();

    List<Cost> selectAllByPage(HashMap<String,Object> map);
}