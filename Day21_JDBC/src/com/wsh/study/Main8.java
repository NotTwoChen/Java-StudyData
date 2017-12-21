package com.wsh.study;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main8 {
    public static void main(String[] args) throws SQLException {

        //dbUtil是apache公司给我们提供的一个工具类

        // 强行翻译(询问执行者)
        QueryRunner queryRunner = new QueryRunnerSon();
        String sql = "select * from hw_user";
        List<User> query = queryRunner.query(
                JdbcUtil.getConnection(),
                sql,
                new ResultSetHandler<List<User>>() {
            @Override
            public List<User> handle(ResultSet resultSet) throws SQLException {
                // TODO 把rusultset中的数据
                // 封装到一个对象中
                List<User> users = new ArrayList<>();
                while (resultSet.next()){
                    User user = new User(
                            resultSet.getString(2),
                            resultSet.getInt(1),
                            resultSet.getInt(3),
                            resultSet.getString(4));
                    users.add(user);
                }
                return users;
            }
        });
        // 对已知的某个类进行扩展

//        Iterator<User> iterator = query.iterator();
        for (User user : query) {
            if (user.getId() == 1) {
                System.out.println(user.toString());
            }
        }


    }
}
