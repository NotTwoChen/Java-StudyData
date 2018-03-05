package com.wsh.cost.service.util;

import com.wsh.cost.domain.Cost;
import com.wsh.util.PageBean;

public class CostPageBean extends PageBean<Cost> {


    private String sort;
    private String value;

    @Override
    public String toString() {
        return "CostPageBean{" +
                "sort='" + sort + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public CostPageBean(int nowPageIndex, int dataCount, String sort, String value) {
        super(nowPageIndex, dataCount);
        this.sort = sort;
        this.value = value;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public CostPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
}
