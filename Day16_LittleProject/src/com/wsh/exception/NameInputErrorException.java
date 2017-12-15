package com.wsh.exception;

public class NameInputErrorException extends SignInException {
    @Override
    public String getMessage() {
        return "昵称输入错误!";
    }
}
