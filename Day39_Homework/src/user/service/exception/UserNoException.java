package user.service.exception;

public class UserNoException extends LoginException {
    @Override
    public String getMessage() {
        return "账号不存在!~";
    }
}
