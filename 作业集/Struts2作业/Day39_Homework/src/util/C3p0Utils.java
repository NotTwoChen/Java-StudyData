package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    // 创建私有化静态成员变量dataSource
    private static DataSource dataSource;
    // 创建私有化静态成员变量threadLocal,并在线程中创建Connection对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    // 静态代码块,方法初始化默认执行
    static {
        // 在静态代码块中为dataSource创建连接池
        dataSource = new ComboPooledDataSource();
    }
    // 从连接池中获得一个连接,如果没有连接,则创建一个连接
    public Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    // 关闭连接池中的连接,如果线程中存在Connection对象则关闭Connection,并清空线程
    public void closeConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection != null){
            connection.close();
            threadLocal.remove();
        }
    }

}
