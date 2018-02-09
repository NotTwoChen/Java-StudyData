package com.wsh.staticproxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticProxyTest {

    @Test
    public void staticProxy() throws Exception {
        UserDao userDao = new UserDaoImpl();
        Transaction transaction = new Transaction();
        UserDaoProxy userDaoProxy = new UserDaoProxy(transaction,userDao);
        userDaoProxy.add();
        userDaoProxy.delete();
    }
}