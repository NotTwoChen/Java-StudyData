package com.wsh.study;

import java.sql.*;

public class Main5 {
    /**
     *  1.PrepareStatement可以使用动态参数
     *          Statement只能执行静态的sql语句
     *
     *  2.防止sql注入
     *          什么是sql注入?
     *          select * from user where username = ? and password = ?
     * @param args
     */

    public static void main(String[] args) {
        JdbcUtil.execute(new ExecuteInter() {
            @Override
            public Statement execute(Connection connection) {
                try {
                    PreparedStatement preparedStatement =
                            connection.prepareStatement("SELECT * FROM hw_user WHERE loc=? AND age >?;");
                    preparedStatement.setString(1,"北京");
                    preparedStatement.setInt(2,20);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    JdbcUtil.showRS(resultSet);
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return null;
            }
        });

        String user = "zhangsan";
        String password = "123";
        String sql = "select * from user where username = " + user
                + "and password = " + password;
    }


}
