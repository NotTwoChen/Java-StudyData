package com.wsh.study;

import com.wsh.utils.JdbcUtil;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class WhQueryRunnerTest {

    @Test
    public void queryByParams() throws SQLException {
        /*
            根据需求结果的类型
                    选择ResultSetHandler的实现类
            如果结果集为单行单列:ScalarHandler      select name or password from userdata where username
            如果想要一个对象:BeanHandler            select * from userdata where username = ?
            如果想要一个对象的集合:BeanListHandler  select * from userdata where username = ? or ?
            如果想要一个Map:MapHandler              select * from userdata where username = ?
            如果想要一个Map的集合:MapListHandler    select * from userdata where username = ? or ?
            如果想要一个数组:ArrayHandler           select * from userdata where username = ?
            如果想要一个数组的集合:ArrayListHandler select * from userdata where username = ? or ?

            单行单列
            单行多列
            多行多列
         */
        Long query = new WhQueryRunner().query(
                JdbcUtil.getConnection(),
                "select count(*) from hw_user",
                new ScalarHandler<Long>()
//                "李小龙"
        );
//        System.out.println(Arrays.toString(query));
//        for (Object[] objects : query) {
//            System.out.println(Arrays.toString(objects));
//        }
        // number类
        // 可以接受任何数组类型的值
        // Number类中有获取各种整型值的方法
        Number number = query;
        // 获得int值
        int i = number.intValue();
        System.out.println(i);
    }

    @Test
    public void queryBean() throws SQLException {
        List<User> query = new WhQueryRunner().query(
                JdbcUtil.getConnection(),
                "select * from hw_user",
                new BeanListHandler<User>(User.class)
        );
        System.out.println(query);
    }
    @Test
    public void queryMap() throws SQLException {
        List<Map<String, Object>> query = new WhQueryRunner().query(
                JdbcUtil.getConnection(),
                "select * from hw_user",
                new MapListHandler()
        );
        for (Map<String, Object> stringObjectMap : query) {
            System.out.println(stringObjectMap.toString());
        }
    }
}