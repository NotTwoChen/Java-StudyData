package com.wsh.exception;

public class UsernameInputErrorException extends SignInException{
    @Override
    public String getMessage() {
        return "账号输入错误!";
    }
}
