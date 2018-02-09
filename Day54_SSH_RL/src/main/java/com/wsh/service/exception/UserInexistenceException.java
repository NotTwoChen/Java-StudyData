package com.wsh.service.exception;

public class UserInexistenceException extends LoginException {

    @Override
    public String getMessage() {
        return "该账号不存在~!";
    }
}
