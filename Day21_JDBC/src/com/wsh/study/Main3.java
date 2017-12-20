package com.wsh.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day20";
        Properties info = new Properties();
        info.load(new FileReader("src/com/wsh/study/db.properties"));
        Connection connection = DriverManager.getConnection(url, info);
        Statement statement = connection.createStatement();
        String update = "update hw_user set uname='李二狗' where uname='张一山'";
        boolean execute = statement.execute(update);
        statement.close();
        connection.close();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
