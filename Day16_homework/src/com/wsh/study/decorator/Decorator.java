package com.wsh.study.decorator;

import com.wsh.study.component.饮品;

public abstract class Decorator extends 饮品 {

    protected 饮品 yp;

    public Decorator(饮品 yp) {
        this.yp = yp;
    }
}
