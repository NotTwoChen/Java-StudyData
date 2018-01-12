package com.wsh.user.service.exception;

public class AdminnameExitException extends LoginException {
    @Override
    public String getMessage() {
        return "账号没有管理员权限!~";
    }
}
