package com.wsh.exception;

public class UsernameInputErrorException extends SignInException{
    @Override
    public String getMessage() {
        return "账号应为手机号或者邮箱!";
    }
}
