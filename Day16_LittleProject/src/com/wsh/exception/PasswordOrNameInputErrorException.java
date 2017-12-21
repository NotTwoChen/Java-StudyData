package com.wsh.exception;

public class PasswordOrNameInputErrorException extends LogInException{
    @Override
    public String getMessage() { return "昵称长度应为5到20位并且只能由英文组成,不区分大小写\n或者昵称长度应为5到20位并且只能由英文组成,不区分大小写!"; }
}
