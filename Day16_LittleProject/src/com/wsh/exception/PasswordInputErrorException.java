package com.wsh.exception;

public class PasswordInputErrorException extends SignInException {
    @Override
    public String getMessage() { return "密码长度应为6到14位并且必须包含大小写字母和数字!"; }
}
