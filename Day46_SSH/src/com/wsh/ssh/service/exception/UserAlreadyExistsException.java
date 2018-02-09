package com.wsh.ssh.service.exception;

public class UserAlreadyExistsException extends RegisterException {

    @Override
    public String getMessage() {
        return "账号已存在~!";
    }
}
