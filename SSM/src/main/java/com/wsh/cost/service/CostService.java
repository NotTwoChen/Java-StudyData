package com.wsh.cost.service;

import com.wsh.cost.domain.Cost;
import com.wsh.cost.service.util.CostPageBean;

public interface CostService {

    CostPageBean queryAll(int nowPageIndex, String sort, String value);

    void addCost(Cost cost);

    Cost queryById(int id);

    void updateById(Cost cost);

    void deleteCost(int id);
}
