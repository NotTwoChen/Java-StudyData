package com.lanou3g.RLFunction.Exception;

/**
 *  创建一个继承LoginErrorException异常类的LoginErrorFromUsernameIsNullErrorException异常类,
 *  即登录错误来自账号不存在异常类.
 */
public class LoginErrorFromUsernameIsNullErrorException extends LoginErrorException {
    /*
        重写构造方法以用于方法抛出异常时被捕获抛至控制台的警告提示信息
     */
    @Override
    public String getMessage() {
        return "账号不存在!!!";
    }


}
