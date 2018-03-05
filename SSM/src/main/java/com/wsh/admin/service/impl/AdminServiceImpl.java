package com.wsh.admin.service.impl;

import com.wsh.admin.dao.AdminInfoMapper;
import com.wsh.admin.domain.AdminInfo;
import com.wsh.admin.service.AdminService;
import com.wsh.admin.service.util.AdminPageBean;
import com.wsh.role.domain.ModuleInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminInfoMapper adminInfoMapper;


    @Override
    public AdminPageBean queryAllByPage(AdminPageBean pageBean) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("moduleId",pageBean.getModuleId());
        map.put("roleName",pageBean.getRoleName());
        pageBean = new AdminPageBean(pageBean.getNowPageIndex(),adminInfoMapper.selectAll(map).size(),pageBean.getModuleId(),pageBean.getRoleName());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<AdminInfo> adminInfos =  adminInfoMapper.selectAllByPage(map);
        pageBean.setList(adminInfos);
        return pageBean;
    }

    @Override
    public Map<String ,Object> updatePassword(Integer[] admin_ids) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("admin_ids",admin_ids);
        map.put("password","123456");
        adminInfoMapper.updatePassword(map);
        map.put("success",true);
        map.put("message","密码重置成功!");
        return map;
    }

    @Override
    public void insertAdmin(AdminInfo adminInfo) {
        adminInfo.setEnrolldate(new Timestamp(System.currentTimeMillis()));
        adminInfoMapper.insert(adminInfo);
        List<Integer> roleIds = adminInfo.getRoleIds();
        HashMap<String, Object> map = new HashMap<>();
        map.put("adminId",adminInfo.getAdminId());
        for (Integer roleId : roleIds) {
            map.put("roleId",roleId);
            adminInfoMapper.insertAdminRole(map);
        }
    }

    @Override
    public AdminInfo queryByAdminId(Integer admin_id) {
        return adminInfoMapper.selectByPrimaryKey(admin_id);
    }

    @Override
    public void updateAdmin(AdminInfo adminInfo) {
        adminInfoMapper.updateByPrimaryKeySelective(adminInfo);
        adminInfoMapper.deleteAdminRole(adminInfo.getAdminId());
        List<Integer> roleIds = adminInfo.getRoleIds();
        HashMap<String, Object> map = new HashMap<>();
        map.put("adminId",adminInfo.getAdminId());
        for (Integer roleId : roleIds) {
            map.put("roleId",roleId);
            adminInfoMapper.insertAdminRole(map);
        }
    }

    @Override
    public void deleteAdmin(Integer admin_id) {
        adminInfoMapper.deleteAdminRole(admin_id);
        adminInfoMapper.deleteByPrimaryKey(admin_id);
    }

    @Override
    public AdminInfo queryByCode(String adminCode) {
        return adminInfoMapper.findByCode(adminCode);
    }

    @Override
    public List<ModuleInfo> queryModulesByAdmin(Integer adminId) {
        return adminInfoMapper.findModulesByAdmin(adminId);
    }
}
