package com.wsh.util;

import com.wsh.user.UserData;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Mysql {

    private static String FILE_NAME = "src/jdbc.properties";
    private static String driverName;
    private static String url;
    private static String database;
    private static String user;
    private static String password;

    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(FILE_NAME));
            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "\n\t\t" + "请将配置文件jdbc.properties放置到src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url+database,user,password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void signIn(String name,String username,String password) throws ClassNotFoundException {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userdata VALUES (?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static UserData logIn (String username) throws SQLException {
        List<UserData> query = getUserData();
        for (UserData user : query) {
            if (user.getUserName().equals(username)){
                return user; } }return null;
    }

    public static List<UserData> getUserData() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from userdata";
        return queryRunner.query(getConnection(), sql, new ResultSetHandler<List<UserData>>() {
            @Override
            public List<UserData> handle(ResultSet resultSet) throws SQLException {
                List<UserData> users = new ArrayList<>();
                while (resultSet.next()){
                    UserData userData = new UserData(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                    users.add(userData);
                }return users; }});
    }
}
