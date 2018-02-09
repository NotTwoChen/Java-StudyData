package com.wsh.factory;

import com.wsh.createobj.User;

public class UserFactory extends AbstractFactory {
    @Override
    public User getInstance() {
        return new User("实例工厂创建的User",11,true);
    }
}
