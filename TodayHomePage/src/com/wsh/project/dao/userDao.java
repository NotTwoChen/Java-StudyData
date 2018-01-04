package com.wsh.project.dao;

import com.wsh.project.bean.User;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static List<User> query(){
        List<User> query = new ArrayList<>();
        try {
            query = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from userdata",
                    new BeanListHandler<User>(User.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public static User query(String username){
        User userData = new User();
        try {
            userData = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from userdata where username = ?",
                    new BeanHandler<User>(User.class),
                    username
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }
    public static User query(String username, String password){
        User userData = new User();
        try {
            Connection connection = JdbcUtil.getConnection();
            userData = new QueryRunner().query(
                    connection,
                    "select * from userdata where username = ? and password = ?",
                    new BeanHandler<User>(User.class),
                    username, password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public static int insert(User userData){
        int update = 0;
        try {
             update = new QueryRunner().update(
                    JdbcUtil.getConnection(),
                    "insert into userdata values(?,?,?)",
                    userData.getName(),
                    userData.getUsername(),
                    userData.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
