package com.wsh.ssh.service.exception;

public class PasswordErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "密码输入错误~!";
    }
}
