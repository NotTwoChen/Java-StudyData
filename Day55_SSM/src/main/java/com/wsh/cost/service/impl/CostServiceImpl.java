package com.wsh.cost.service.impl;

import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.CostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("costService")
public class CostServiceImpl implements CostService {


    private CostMapper costMapper;

    public CostServiceImpl() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//        costMapper = (CostMapper) context.getBean("costMapper");
    }

    @Override
    public List<Cost> queryAll() {
        return costMapper.selectAll();
    }
}
