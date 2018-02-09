package com.wsh.ssh.dao;

import com.wsh.ssh.domain.User;

public interface UserDao {

    void add(User form);
    void delete(User form);
    void update(User form);
    User query(String username);

}
