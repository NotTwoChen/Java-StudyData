package com.wsh.exception;

public class UserNameExistException extends SignInException {

    @Override
    public String getMessage() {
        return "账号已存在!";
    }
}
