package com.wsh.dao.impl;

import com.wsh.dao.UserDao;
import com.wsh.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) {
        return null;
    }

    public List<User> findUsersByName(String username) {
        return null;
    }

    public void insertUser(User user) {

    }
}
