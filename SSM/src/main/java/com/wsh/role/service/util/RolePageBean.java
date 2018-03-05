package com.wsh.role.service.util;

import com.wsh.role.domain.RoleInfo;
import com.wsh.util.PageBean;

public class RolePageBean extends PageBean<RoleInfo> {


    public RolePageBean() {
    }

    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public RolePageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }

}
