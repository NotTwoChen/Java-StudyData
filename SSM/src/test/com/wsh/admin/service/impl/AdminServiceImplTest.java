package com.wsh.admin.service.impl;

import com.wsh.admin.dao.AdminInfoMapper;
import com.wsh.admin.domain.AdminInfo;
import com.wsh.admin.service.AdminService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() throws Exception {
        AdminInfoMapper adminInfoMapper = (AdminInfoMapper) context.getBean("adminInfoMapper");
        HashMap<String,Object> map = new HashMap<>();
        map.put("moduleId","");
        map.put("roleName","");
        map.put("start",0);
        map.put("pageSize",5);
        List<AdminInfo> adminInfos = adminInfoMapper.selectAllByPage(map);
        for (AdminInfo adminInfo : adminInfos) {
            System.out.println(adminInfo);
        }
    }

    @Test
    public void test2() throws Exception {
        AdminService adminService = (AdminService) context.getBean("adminService");
        Integer[] admin_ids = {2000,3000};
        adminService.updatePassword(admin_ids);
    }
}