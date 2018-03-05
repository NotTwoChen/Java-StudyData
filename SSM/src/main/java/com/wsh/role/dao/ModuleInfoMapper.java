package com.wsh.role.dao;

import com.wsh.role.domain.ModuleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleInfoMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);

    ModuleInfo selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(ModuleInfo record);

    int updateByPrimaryKey(ModuleInfo record);

    List<ModuleInfo> selectAll();
}