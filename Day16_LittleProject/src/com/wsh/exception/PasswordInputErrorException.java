package com.wsh.exception;

public class PasswordInputErrorException extends SignInException {
    @Override
    public String getMessage() {
        return "密码输入错误!";
    }
}
