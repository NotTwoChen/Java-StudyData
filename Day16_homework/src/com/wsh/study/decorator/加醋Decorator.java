package com.wsh.study.decorator;

import com.wsh.study.component.饮品;

public class 加醋Decorator extends Decorator {

    public 加醋Decorator(饮品 yp) {
        super(yp);
    }
    @Override
    public int price() {
        return 5+yp.price();
    }

    @Override
    public String getName() {
        return "加醋的"+yp.getName();
    }
}
