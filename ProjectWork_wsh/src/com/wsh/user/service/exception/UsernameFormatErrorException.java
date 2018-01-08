package com.wsh.user.service.exception;

public class UsernameFormatErrorException extends RegisterException {

    @Override
    public String getMessage() {
        return "用户名应由字母开头且可以为和数字/下划线组成,长度不能超过16位";
    }
}
