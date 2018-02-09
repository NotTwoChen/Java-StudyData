package com.wsh.service.exception;

public class UserMismatchingException extends LoginException {

    @Override
    public String getMessage() {
        return "账号密码错误~!";
    }
}
