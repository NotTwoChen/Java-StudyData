package com.wsh.project.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    private static String driverName;
    private static String url;
    private static String database;
    private static String user;
    private static String password;

    static{
        Properties properties = new Properties();
        ClassLoader classLoader = JdbcUtil.class.getClassLoader();
        InputStream jdbc = classLoader.getResourceAsStream("jdbc.properties");
        try {
            properties.load(jdbc);
            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url + database, user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
