package user.service.exception;

public class UserExistsException extends RegisterException {
    @Override
    public String getMessage() {
        return "账号已存在!~";
    }
}
