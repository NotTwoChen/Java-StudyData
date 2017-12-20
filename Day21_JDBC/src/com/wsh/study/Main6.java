package com.wsh.study;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main6 {
    public static void main(String[] args) {

        // {}就是匿名内部类实现ExecuteInter接口时
        // 复写的那个方法execute的方法体
        // connection就是execute方法的参数

        JdbcUtil.execute(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO hw_user VALUES (NULL ,'张三',30,'上海')");
                // 将30岁的张三插入到批处理中
                preparedStatement.addBatch();

                // 添加批处理任务
                preparedStatement.addBatch("INSERT  INTO hw_user VALUES (NULL ,'李四',10,'武汉')");
                preparedStatement.addBatch("INSERT  INTO hw_user VALUES (NULL ,'张三',11,'武汉')");

                // 开始执行批处理任务
                preparedStatement.executeBatch();
                return preparedStatement;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

}
