package com.wsh.service.impl;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;
import com.wsh.service.UserService;
import com.wsh.service.exception.UserAlreadyExistException;
import com.wsh.service.exception.UserInexistenceException;
import com.wsh.service.exception.UserMismatchingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void register(User form) throws UserAlreadyExistException {
        User user = userDao.queryByUsername(form.getUsername());
        if (user == null){
            userDao.insertOrUpdate(form);
        }else {
            throw new UserAlreadyExistException();
        }
    }

    public void login(User form) throws UserInexistenceException, UserMismatchingException {
        User user = userDao.queryByUsername(form.getUsername());
        if (user != null){
            if (!user.getPassword().equals(form.getUsername())){
                throw new UserMismatchingException();
            }else {
                throw new UserInexistenceException();
            }
        }
    }

    public void cancel(User form) {
        userDao.delete(form);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
