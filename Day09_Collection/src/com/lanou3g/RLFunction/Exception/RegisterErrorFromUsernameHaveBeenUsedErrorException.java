package com.lanou3g.RLFunction.Exception;

/**
 *  创建一个继承RegisterErrorException异常类的RegisterErrorFromUsernameHaveBeenUsedErrorException异常类,
 *  即登录错误来自账号已被使用异常类.
 */
public class RegisterErrorFromUsernameHaveBeenUsedErrorException extends RegisterErrorException {
/*
    重写构造方法以用于方法抛出异常时被捕获抛至控制台的警告提示信息
 */
    @Override
    public String getMessage() {
        return "账号已存在!!!";
    }
}
