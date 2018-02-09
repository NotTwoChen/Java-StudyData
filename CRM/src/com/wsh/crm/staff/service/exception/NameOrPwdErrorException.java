package com.wsh.crm.staff.service.exception;

public class NameOrPwdErrorException extends LoginException {

    @Override
    public String getMessage() {
        return "账号或密码错误~!";
    }
}
