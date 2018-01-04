package com.wsh.project.dao;

import com.wsh.project.bean.UserData;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static List<UserData> query(){
        List<UserData> query = new ArrayList<>();
        try {
            query = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from userdata",
                    new BeanListHandler<UserData>(UserData.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public static UserData query(String username){
        UserData userData = new UserData();
        try {
            userData = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from userdata where username = ?",
                    new BeanHandler<UserData>(UserData.class),
                    username
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }
    public static UserData query(String username,String password){
        UserData userData = new UserData();
        try {
            Connection connection = JdbcUtil.getConnection();
            userData = new QueryRunner().query(
                    connection,
                    "select * from userdata where username = ? and password = ?",
                    new BeanHandler<UserData>(UserData.class),
                    username, password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public static int insert(UserData userData){
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
