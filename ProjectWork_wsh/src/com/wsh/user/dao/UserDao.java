package com.wsh.user.dao;

import com.wsh.user.domain.User;
import com.wsh.util.PerfectQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    private static PerfectQueryRunner pqr = new PerfectQueryRunner();

    public User findByUsername(String username){
        User user = new User();
        try {
            user = pqr.query(
                    "select * from user where username=?",
                    new BeanHandler<User>(User.class),
                    username
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User findByEmail(String email){
        User user = new User();
        try {
            user = pqr.query(
                    "select * from user where email=?",
                    new BeanHandler<User>(User.class),
                    email
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void insert(User form){
        try {
            pqr.update(
                    "insert into user values(?,?,?,?,?,?)",
                    form.getUid(),
                    form.getUsername(),
                    form.getPassword(),
                    form.getEmail(),
                    form.getCode(),
                    form.getState()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int update(String code){
        int update = 0;
        try {
            update = pqr.update(
                    "update user set state=1 where code=?",
                    code
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
