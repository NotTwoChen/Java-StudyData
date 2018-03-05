package com.wsh.cost.service.impl;

import com.wsh.cost.dao.CostMapper;
import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.CostService;
import com.wsh.cost.service.util.CostPageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("costService")
@Transactional
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    private CostPageBean pageBean;

    @Override
    public CostPageBean queryAll(int nowPageIndex,String sort,String value) {
        pageBean = new CostPageBean(nowPageIndex,costMapper.selectAll().size(),sort,value);
        HashMap<String,Object> map = new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        map.put("sort",sort);
        map.put("value",value);
        List<Cost> costs = costMapper.selectAllByPage(map);
        pageBean.setList(costs);
        return pageBean;
    }


    @Override
    public void addCost(Cost cost) {
        costMapper.insertSelective(cost);
    }

    @Override
    public Cost queryById(int id) {
        return costMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Cost cost) {
        costMapper.updateByPrimaryKey(cost);
    }

    @Override
    public void deleteCost(int id) {
        costMapper.deleteByPrimaryKey(id);
    }
}
