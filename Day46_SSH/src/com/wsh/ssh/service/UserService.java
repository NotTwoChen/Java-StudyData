package com.wsh.ssh.service;

import com.wsh.ssh.dao.UserDao;
import com.wsh.ssh.domain.User;
import com.wsh.ssh.service.exception.PasswordErrorException;
import com.wsh.ssh.service.exception.UserAlreadyExistsException;
import com.wsh.ssh.service.exception.UserExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void register(User form) throws UserAlreadyExistsException {
        User user = userDao.query(form.getUsername());
        if (user == null){
            userDao.add(form);
        }else {
            throw new UserAlreadyExistsException();
        }
    }

    public User login(User form) throws UserExitException, PasswordErrorException {
        User user = userDao.query(form.getUsername());
        if (user == null){
            throw new UserExitException();
        }else if (!user.getPassword().equals(form.getPassword())){
            throw new PasswordErrorException();
        }else {
            return user;
        }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
