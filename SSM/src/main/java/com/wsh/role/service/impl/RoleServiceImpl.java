package com.wsh.role.service.impl;

import com.wsh.role.dao.ModuleInfoMapper;
import com.wsh.role.dao.RoleInfoMapper;
import com.wsh.role.dao.RoleModuleMapper;
import com.wsh.role.domain.ModuleInfo;
import com.wsh.role.domain.RoleInfo;
import com.wsh.role.domain.RoleModule;
import com.wsh.role.service.RoleService;
import com.wsh.role.service.util.RolePageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleInfoMapper roleInfoMapper;
    @Resource
    private ModuleInfoMapper moduleInfoMapper;
    @Resource
    private RoleModuleMapper roleModuleMapper;


    @Override
    public RolePageBean queryAllByPage(RolePageBean pageBean) {
        pageBean = new RolePageBean(pageBean.getNowPageIndex(),roleInfoMapper.selectAll().size());
        HashMap<String,Object> map = new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<RoleInfo> roleInfos = roleInfoMapper.selectAllByPage(map);
        for (RoleInfo roleInfo : roleInfos) {
            getRole(roleInfo);
        }
        pageBean.setList(roleInfos);
        return pageBean;
    }


    @Override
    public List<ModuleInfo> queryAllModule() {
        return moduleInfoMapper.selectAll();
    }

    @Override
    public RoleInfo queryByRoleId(int role_id) {
        RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(role_id);
        getRole(roleInfo);
        return roleInfo;
    }

    @Override
    public void updateRole(RoleInfo roleInfo) {
        roleInfoMapper.updateByPrimaryKey(roleInfo);
        roleModuleMapper.deleteRoleModules(roleInfo.getRoleId());
        List<Integer> moduleIds = roleInfo.getModuleIds();
        for (Integer moduleId : moduleIds) {
            RoleModule roleModule = new RoleModule(roleInfo.getRoleId(), moduleId);
            roleModuleMapper.insert(roleModule);
        }
    }

    @Override
    public void insertRole(RoleInfo roleInfo) {
        roleInfoMapper.insert(roleInfo);
        List<Integer> moduleIds = roleInfo.getModuleIds();
        for (Integer moduleId : moduleIds) {
            RoleModule roleModule = new RoleModule(roleInfo.getRoleId(), moduleId);
            roleModuleMapper.insert(roleModule);
        }
    }

    @Override
    public void deleteRole(int role_id) {
        roleModuleMapper.deleteRoleModules(role_id);
        roleInfoMapper.deleteByPrimaryKey(role_id);
    }

    @Override
    public List<RoleInfo> queryAllRole() {
        return roleInfoMapper.selectAll();
    }

    private void getRole(RoleInfo roleInfo) {
        List<Integer> moduleIds = new ArrayList<>();
        List<ModuleInfo> moduleInfos = new ArrayList<>();

        List<RoleModule> roleModules = roleModuleMapper.selectByRoleId(roleInfo.getRoleId());
        for (RoleModule roleModule : roleModules) {
            moduleIds.add(roleModule.getModuleId());
        }
        roleInfo.setModuleIds(moduleIds);

        for (Integer moduleId : moduleIds) {
            ModuleInfo moduleInfo = moduleInfoMapper.selectByPrimaryKey(moduleId);
            moduleInfos.add(moduleInfo);
        }
        roleInfo.setModuleInfos(moduleInfos);
    }
}
