package com.wsh.user.service.exception;

public class EmailHasBeenRegisteredException extends RegisterException {
    @Override
    public String getMessage() {
        return "邮箱已被注册!~";
    }
}
