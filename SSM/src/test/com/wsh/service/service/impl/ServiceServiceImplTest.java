package com.wsh.service.service.impl;

import com.wsh.account.dao.AccountMapper;
import com.wsh.account.domain.Account;
import com.wsh.cost.domain.Cost;
import com.wsh.service.dao.ServiceMapper;
import com.wsh.service.domain.Service;
import com.wsh.service.service.ServiceService;
import com.wsh.service.service.util.ServicePageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ServiceServiceImplTest {

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
        ServiceMapper serviceMapper = (ServiceMapper) context.getBean("serviceMapper");
        HashMap<String,Object> map = new HashMap<>();
        map.put("osUsername","");
        map.put("unixHost","");
        map.put("idcardNo","");
        map.put("status","");
        map.put("start",0);
        map.put("pageSize",5);
        List<Service> services = serviceMapper.selectAll(map);
        for (Service service : services) {
            System.out.println("---"+service.getCreateDate());
            Account account = service.getAccount();
            System.out.println("------"+account.getCreateDate());
            Cost cost = service.getCost();
            System.out.println("-----------" + cost.getCreatime());
        }
    }

    @Test
    public void test2() throws Exception {
        ServiceService serviceService = (ServiceService) context.getBean("serviceService");
        ServicePageBean servicePageBean = serviceService.queryAllByPage(new ServicePageBean());
        List<Service> list = servicePageBean.getList();
        for (Service service : list) {
            System.out.println(service);

        }
    }

    @Test
    public void test3() throws Exception {
        ServiceService serviceService = (ServiceService) context.getBean("serviceService");
        Map<String, Object> map = serviceService.queryAccountByIdcardNo("421222199701270011");
        System.out.println(map);
//        AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
//        Account account = accountMapper.selectByIdcardNo("421222199701270011");
//        System.out.println(account);
    }
}