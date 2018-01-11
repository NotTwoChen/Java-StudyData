package com.wsh.user.service.exception;

public class AdminnameExitException extends LoginException {
    @Override
    public String getMessage() {
        return "管理员账户不存在!~";
    }
}
