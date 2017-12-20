package com.wsh.study;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main7 {

    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        /**
         *  事物的四个特性
         *      原子性
         *      一致性
         *      隔离性
         *      持久性
         *
         *      统称为ACID
         */
        JdbcUtil.execute(connection -> {
            // 设置为false,表示手动提交
            // 也就是开启了事务
            // 默认是自动提交的
            try {
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM hw_user WHERE uname=?"
                );
                preparedStatement.setString(1,"张三");
                preparedStatement.execute();
//                Class.forName("");
                preparedStatement.setString(1,"李四");
                preparedStatement.execute();
                // 提交事务
                connection.commit();
//                return preparedStatement;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                // 回滚,取消操作
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            return preparedStatement;
        });
    }

}
