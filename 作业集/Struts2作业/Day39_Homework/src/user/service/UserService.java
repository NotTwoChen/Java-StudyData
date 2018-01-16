package user.service;

import user.bean.User;
import user.dao.UserDao;
import user.service.exception.PasswordErrorException;
import user.service.exception.UserExistsException;
import user.service.exception.UserNoException;

public class UserService {

    private static UserDao ud = new UserDao();

    public void register(User form) throws UserExistsException {
        User user = ud.queryByUsername(form.getUsername());
        if (user == null){
            ud.insert(form);
        }else {
            throw new UserExistsException();
        }
    }
    public void login(User form) throws UserNoException, PasswordErrorException {
        User user = ud.queryByUsername(form.getUsername());
        if (user != null){
            if (user.getPassword().equals(form.getPassword())){
            }else {
                throw new PasswordErrorException();
            }
        }else {
            throw new UserNoException();
        }
    }
}
