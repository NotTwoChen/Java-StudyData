package com.wsh.user.service.exception;

public class AdminPasswordErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "管理员账户密码错误!~";
    }
}
