package com.wsh.cgproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgProxy implements MethodInterceptor {
    private Object target;
    private CgTransaction cgTransaction;

    public CgProxy(Object object, CgTransaction cgTransaction) {
        this.target = object;
        this.cgTransaction = cgTransaction;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        cgTransaction.begin();
        method.invoke(target,objects);
        cgTransaction.commit();
        return null;
    }
}
