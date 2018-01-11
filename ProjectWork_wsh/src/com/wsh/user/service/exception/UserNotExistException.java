package com.wsh.user.service.exception;

public class UserNotExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户不存在!~";
    }
}
