package com.wsh.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String FILE_NAME = "src/jdbc.properties";
    private static String url;
    private static String database;
    private static String user;
    private static String password;
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(FILE_NAME));
            String driverName = properties.getProperty("driverName");
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

    public static void execute(ExecuteInter executeInter){
        try {
            Connection connection = getConnection();
            executeInter.execute(connection).close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showRS(ResultSet resultSet){
        try {
            while (resultSet.next()){
                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");
                System.out.print(resultSet.getString(4) + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet,Statement statement,Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement statement,Connection connection){
        close(null,statement,connection);
    }
    public static void close(Connection connection){
        close(null,connection);
    }
    public static void close(){
        close(null);
    }
}
