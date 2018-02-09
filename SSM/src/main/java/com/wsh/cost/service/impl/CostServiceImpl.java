package com.wsh.cost.service.impl;

import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.CostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("costService")
@Transactional
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    @Override
    public List<Cost> queryAll() {
        return costMapper.selectAll();
    }
}
