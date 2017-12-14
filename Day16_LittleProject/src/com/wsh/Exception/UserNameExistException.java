package com.wsh.Exception;

public class UserNameExistException extends SignInException {

    @Override
    public String getMessage() {
        return "账号已存在!";
    }
}
