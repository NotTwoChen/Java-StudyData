package com.wsh.action;

import com.wsh.bean.Demo;
import com.wsh.util.BaseDao;
import com.wsh.util.BaseDaoImpl;

public class DemoAction {

    private BaseDao<Demo> baseDao = new BaseDaoImpl();

    public String demo(){
        // 假装我是一个Struts2的action
        // 基本POJO类也可以作为action使用
        baseDao.add(new Demo());
        return "success";
    }
}
