package com.wsh.ssh.service.exception;

public class UserExitException extends LoginException {
    @Override
    public String getMessage() {
        return "账号不存在";
    }
}
