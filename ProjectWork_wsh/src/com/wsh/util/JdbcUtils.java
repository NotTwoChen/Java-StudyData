package com.wsh.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public JdbcUtils() {
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null){
            return connection;
        }
        return dataSource.getConnection();
    }
    public static void beginTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null) {
            throw new SQLException("The Transaction has started!~");
        } else {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            threadLocal.set(connection);
        }
    }
    public static void commitTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            throw new SQLException("The Transaction does't exist,can't be committed!~");
        } else {
            connection.commit();
            connection.close();
            connection = null;
            threadLocal.remove();
        }
    }
    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            throw new SQLException("The Transaction does't exist,can't be rolled back!~");
        } else {
            connection.rollback();
            connection.close();
            connection = null;
            threadLocal.remove();
        }
    }
    public static void releaseConnection(Connection con) throws SQLException {
        Connection connection = threadLocal.get();
        if (con != connection && con != null && !con.isClosed()) {
            con.close();
        }
    }
}
