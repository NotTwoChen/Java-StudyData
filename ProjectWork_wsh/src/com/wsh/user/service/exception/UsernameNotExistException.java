package com.wsh.user.service.exception;

public class UsernameNotExistException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在!~";
    }
}
