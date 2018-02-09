package com.wsh.cost.service;

import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class CostServiceTest {

    private CostMapper costMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        costMapper = (CostMapper) context.getBean("costMapper");
    }

    @Test
    public void test() throws Exception {
        List<Cost> costs = costMapper.selectAll();
        for (Cost cost : costs) {
            System.out.println(cost);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

}