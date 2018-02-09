package com.wsh.service;

import com.wsh.domain.User;
import com.wsh.service.exception.UserAlreadyExistException;
import com.wsh.service.exception.UserInexistenceException;
import com.wsh.service.exception.UserMismatchingException;

public interface UserService {

    void register(User form) throws UserAlreadyExistException;

    void login(User form) throws UserInexistenceException, UserMismatchingException;

    void cancel(User form);
}
