package com.wsh.admin.dao;

import com.wsh.admin.domain.AdminInfo;
import com.wsh.role.domain.ModuleInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AdminInfoMapper {

    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);

    List<AdminInfo> selectAll(HashMap<String,Object> map);

    List<AdminInfo> selectAllByPage(HashMap<String, Object> map);

    void updatePassword(HashMap<String, Object> map);

    void insertAdminRole(HashMap<String, Object> map);

    void deleteAdminRole(Integer adminId);

    AdminInfo findByCode(String adminCode);

    List<ModuleInfo> findModulesByAdmin(Integer adminId);
}