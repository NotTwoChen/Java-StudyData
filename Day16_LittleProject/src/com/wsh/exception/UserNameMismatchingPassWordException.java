package com.wsh.exception;

public class UserNameMismatchingPassWordException extends LogInException {

    @Override
    public String getMessage() {
        return "账号或者密码输入错误!";
    }
}
