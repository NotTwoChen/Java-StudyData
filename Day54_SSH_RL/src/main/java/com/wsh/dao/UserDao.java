package com.wsh.dao;


import com.wsh.domain.User;

import java.util.List;

public interface UserDao {

    List<User> queryAll();

    User queryByUid(int uid);

    User queryByUsername(String username);

    void insertOrUpdate(User user);

    void delete(User user);

}
