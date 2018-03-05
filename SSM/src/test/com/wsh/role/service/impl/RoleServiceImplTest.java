package com.wsh.role.service.impl;

import com.wsh.role.dao.RoleInfoMapper;
import com.wsh.role.domain.ModuleInfo;
import com.wsh.role.domain.RoleInfo;
import com.wsh.role.service.RoleService;
import com.wsh.role.service.util.RolePageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class RoleServiceImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void name() throws Exception {
        RoleInfoMapper roleInfoMapper = (RoleInfoMapper) context.getBean("roleInfoMapper");
//        RoleInfo roleInfo = roleInfoMapper.selectByPrimaryKey(300);
        HashMap<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("pageSize",5);
        List<RoleInfo> roleInfos = roleInfoMapper.selectAllByPage(map);
        for (RoleInfo roleInfo : roleInfos) {
            System.out.println(roleInfo);
            List<ModuleInfo> moduleInfos = roleInfo.getModuleInfos();
            for (ModuleInfo moduleInfo : moduleInfos) {
                System.out.println("-----"+moduleInfo);
            }
            List<Integer> moduleIds = roleInfo.getModuleIds();
            for (Integer moduleId : moduleIds) {
                System.out.println("---------"+moduleId);
            }
        }
    }

    @Test
    public void name1() throws Exception {
        RoleService roleService = (RoleService) context.getBean("roleService");
        RolePageBean rolePageBean = roleService.queryAllByPage(new RolePageBean());
        System.out.println(rolePageBean);
        List<RoleInfo> roleInfos = rolePageBean.getList();
        for (RoleInfo roleInfo : roleInfos) {
            System.out.println(roleInfo);
        }
    }
}