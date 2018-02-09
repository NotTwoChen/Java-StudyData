package com.wsh.service.exception;

public class UserAlreadyExistException extends RegisterException {

    @Override
    public String getMessage() {
        return "该账号已存在~!";
    }
}
