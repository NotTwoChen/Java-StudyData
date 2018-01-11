package com.wsh.user.service.exception;

public class UserActivatedException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户已激活!~";
    }
}
