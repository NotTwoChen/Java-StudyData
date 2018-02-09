package com.wsh.jdkproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    @Test
    public void jdkTest() throws Exception {
        JdkUserDao jdkUserDao = new JdkUserDaoImpl();
        JdkTransaction jdkTransaction = new JdkTransaction();
        JdkProxy jdkProxy = new JdkProxy(jdkUserDao, jdkTransaction);
        Object o = Proxy.newProxyInstance(
                jdkUserDao.getClass().getClassLoader(),
                jdkUserDao.getClass().getInterfaces(),
                jdkProxy);
        System.out.println(o.getClass().getName());
    }
}