package com.wsh.role.dao;

import com.wsh.role.domain.RoleModule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    List<RoleModule> selectByRoleId(Integer roleId);

    void deleteRoleModules(Integer roleId);
}