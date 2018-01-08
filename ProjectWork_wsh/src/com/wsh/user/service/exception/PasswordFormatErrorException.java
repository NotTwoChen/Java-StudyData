package com.wsh.user.service.exception;

public class PasswordFormatErrorException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码应至少包含大小写字母和数字且长度为6到14位!~";
    }
}
