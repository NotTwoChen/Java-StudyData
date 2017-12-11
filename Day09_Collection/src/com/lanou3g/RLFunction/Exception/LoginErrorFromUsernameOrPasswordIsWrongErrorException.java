package com.lanou3g.RLFunction.Exception;

/**
 *  创建一个继承LoginErrorException异常类的LoginErrorFromUsernameOrPasswordIsWrongErrorException异常类,
 *  即登录错误异常来自账号或者密码不正确异常类.
 */
public class LoginErrorFromUsernameOrPasswordIsWrongErrorException extends LoginErrorException {
    /*
        重写构造方法以用于方法抛出异常时被捕获抛至控制台的警告提示信息
     */
    @Override
    public String getMessage() {
        return "账号或密码输入错误!!!";
    }
}
