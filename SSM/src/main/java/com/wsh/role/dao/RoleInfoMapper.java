package com.wsh.role.dao;

import com.wsh.role.domain.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface RoleInfoMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    List<RoleInfo> selectAll();

    List<RoleInfo> selectAllByPage(HashMap<String, Object> map);
}