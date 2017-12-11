package com.lanou3g.yesterday.two;

import com.lanou3g.yesterday.one.DataBaseUtil;

public class OperateDBlmpl<T> implements OperateDB<T> {

    @Override
    public T operate(T t) {
        DataBaseUtil<T> dataBaseUtil = new DataBaseUtil<>();
        dataBaseUtil.save(t);

        return null;
    }
}
