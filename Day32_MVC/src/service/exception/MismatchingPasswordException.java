package service.exception;

public class MismatchingPasswordException extends LoginException {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
