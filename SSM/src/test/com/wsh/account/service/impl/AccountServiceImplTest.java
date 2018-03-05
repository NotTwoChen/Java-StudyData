package com.wsh.account.service.impl;

import com.wsh.account.dao.AccountMapper;
import com.wsh.account.domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceImplTest {

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
        AccountMapper accountMapper = (AccountMapper) context.getBean("accountMapper");
//        Account account = accountMapper.selectByPrimaryKey(1);
//        Account recommenderAccount = account.getRecommenderAccount();
//        System.out.println(account);
//        System.out.println(recommenderAccount);
        HashMap<String, Object> map = new HashMap<>();
        map.put("start",0);
        map.put("pageSize",5);
        List<Account> accounts = accountMapper.selectAll(map);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}