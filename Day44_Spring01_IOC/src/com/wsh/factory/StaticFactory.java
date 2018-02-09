package com.wsh.factory;

import com.wsh.createobj.User;

public class StaticFactory {

    // 静态工厂
    public static User getInstance(){
        return new User();
    }


}
