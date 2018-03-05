package com.wsh.cost.service.impl;

import com.wsh.account.dao.AccountMapper;
import com.wsh.account.domain.Account;
import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class Test {


    private CostMapper costMapper;
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
        costMapper = (CostMapper) context.getBean("costMapper");
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void test() throws Exception {
        AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
        List<Account> accounts = accountMapper.selectAll(new HashMap<>());
        for (Account account : accounts) {
            System.out.println(account);
        }
        List<Cost> costs = costMapper.selectAll();
        for (Cost cost : costs) {
            System.out.println(cost);
        }
    }

    @org.junit.Test
    public void name() throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("pageSize",6);
        map.put("sort","asc");
        map.put("value","base_cost");
        List<Cost> costs = costMapper.selectAllByPage(map);
        for (Cost cost : costs) {
            System.out.println(cost);
        }
    }
}