package com.wsh.user.service.exception;

public class UsernameHasBeenRegisteredException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已被注册!~";
    }
}
