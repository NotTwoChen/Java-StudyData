package com.wsh.user.service.exception;

public class UserNotActiveException extends LoginException {
    @Override
    public String getMessage() {
        return "用户未激活!~";
    }
}
