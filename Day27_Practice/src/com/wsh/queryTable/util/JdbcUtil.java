package com.wsh.queryTable.util;


import com.wsh.queryTable.override.NewQueryRunner;
import com.wsh.queryTable.dao.UserData;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JdbcUtil {

    private static String driverName;
    private static String url;
    private static String database;
    private static String username;
    private static String password;

    public static void getJdbcUtil(InputStream inputStream) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(inputStream);
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        database = properties.getProperty("database");
        username = properties.getProperty("user");
        password = properties.getProperty("password");
        Class.forName(driverName);
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url + database, username, password);
        return connection;
    }
    public static List<UserData> getListOfQuery() throws SQLException {
        List<UserData> query = new NewQueryRunner().query(
                getConnection(),
                "select * from userdata",
                new BeanListHandler<UserData>(UserData.class)
        );
        return query;
    }
    public static void insertUserDataForSql(UserData userData) throws SQLException {
        new NewQueryRunner().update(
                getConnection(),
                "insert into userdata values(?,?,?)",
                userData.getName(),
                userData.getUsername(),
                userData.getPassword()
        );
    }
}
