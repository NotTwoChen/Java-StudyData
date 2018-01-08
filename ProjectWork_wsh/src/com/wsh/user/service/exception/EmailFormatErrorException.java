package com.wsh.user.service.exception;

public class EmailFormatErrorException extends RegisterException {
    @Override
    public String getMessage() {
        return "邮箱格式不正确!~";
    }
}
