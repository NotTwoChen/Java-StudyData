package com.wsh.exception;

public class UsernameInexistenceException extends LogInException {

    @Override
    public String getMessage() {
        return "账号不存在!";
    }
}
