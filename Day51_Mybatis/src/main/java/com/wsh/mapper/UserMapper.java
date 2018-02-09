package com.wsh.mapper;

import com.wsh.domain.User;

import java.util.List;

public interface UserMapper {

    User findUserById(int id);

    List<User> findUsersByName(String username);

    void insertUser(User user);

    User findUserByIdResultMap(int i);

}
