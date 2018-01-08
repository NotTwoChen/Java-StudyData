package service;

import dao.UserDao;
import domain.User;
import service.exception.InvalidUsernameException;
import service.exception.LoginException;
import service.exception.MismatchingPasswordException;



public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user) throws LoginException {
        User formDb = userDao.queryByUsername(user.getUsername());
        if (formDb == null) {
            throw new InvalidUsernameException();
        }
        // 如果查出的用户名与输入的用户名不相同
        if (!formDb.getPassword().equals(user.getPassword())){
            // 抛出密码不匹配异常
            throw new MismatchingPasswordException();
        }

        return formDb;
    }
}
