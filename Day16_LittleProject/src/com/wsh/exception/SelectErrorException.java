package com.wsh.exception;

public class SelectErrorException extends LogInException {
    @Override
    public String getMessage() {
        return "选择操作错误!";
    }
}
