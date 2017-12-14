package com.wsh.Exception;

public class UserNameMismatchingPassWordException extends LogInException {

    @Override
    public String getMessage() {
        return "账号或者密码错误!";
    }
}
