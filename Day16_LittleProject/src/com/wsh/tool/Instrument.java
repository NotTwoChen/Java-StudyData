package com.wsh.tool;

import com.wsh.user.UserData;
import com.wsh.util.Mysql;
import com.wsh.util.QueryRunnerSon;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Instrument {

    private static String sql;

    public static void instru(Instruction instruction){
        Connection connection = Mysql.getConnection();
        try {
            connection.setAutoCommit(false);
            instruction.connection(connection);
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inset(String name,String username,String password){
        instru(new Instruction() {
            @Override
            public void connection(Connection connection) {
                try {
                    in(connection,name,username,password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void in(Connection connection,String name,String username,String password) throws SQLException {
        String sql = "INSERT INTO userdata VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,username);
        preparedStatement.setString(3,password);
        preparedStatement.execute();
    }

    // 增
    public static void insert(String name,String username,String password) throws SQLException {
            Connection connection = Mysql.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userdata VALUES (?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.execute();
            connection.commit();
            connection.close();
    }
    // 删
    public static void delete(String username) throws SQLException {
            Connection connection = Mysql.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userdata WHERE username=?");
            preparedStatement.setString(1,username);
            preparedStatement.execute();
            connection.commit();
            connection.close();
    }
    // 改
    public static void update(String name,String username,String password) throws SQLException {
            Connection connection = Mysql.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE userdata SET name=? ,password=? WHERE username=?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,username);
            preparedStatement.execute();
            connection.commit();
            connection.close();
    }
    // 查
    // 单行单列/单行多列/多行多列
    public static String queryScalar(String querydata,String username) throws SQLException {
        sql = "select " + querydata + " from userdata where username =?";
        String query = new QueryRunnerSon().query(
                Mysql.getConnection(),
                sql,
                new ScalarHandler<String>(),
                username
        );
        return query;
    }
    public static List<UserData> queryBean(String... usernames) throws SQLException {
        sql = "select * from userdata where username =?";
        List<UserData> list = new ArrayList<UserData>();
        for (String username : usernames) {
            UserData query = new QueryRunnerSon().query(
                    Mysql.getConnection(),
                    sql,
                    new BeanHandler<UserData>(UserData.class),
                    username
            );
            list.add(query);
        }
        return list;
    }
    public static List<Map<String,Object>> queryMap(String...usernames) throws SQLException {
        sql = "select * from userdata where username =?";
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (String username : usernames) {
            Map<String, Object> query = new QueryRunnerSon().query(
                    Mysql.getConnection(),
                    sql,
                    new MapHandler(),
                    username
            );
            list.add(query);
        }
        return list;
    }
    public static List<Object[]> queryArray(String...usernames) throws SQLException {
        sql = "select * from userdata where username =?";
        List<Object[]> list = new ArrayList<Object[]>();
        for (String username : usernames) {
            Object[] query = new QueryRunnerSon().query(
                    Mysql.getConnection(),
                    sql,
                    new ArrayHandler(),
                    username
            );
            list.add(query);
        }
        return list;
    }


    public static void main(String[] args) {

//            queryBean("1");
//            queryMap("1","2");
//            queryArray("1","2","18827311614");
//            queryScalar("password", "18827311614");
//            insert("4","4","4");
//            delete("3");
//            update("5","2","5");
            inset("67","76","67");

    }
}
