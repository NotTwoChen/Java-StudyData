import org.junit.Test;
import util.DBCPUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class T {

    @Test
    public void t1() throws SQLException {
        Connection connection = DBCPUtil.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void t2() throws SQLException {
        for (int i = 0; i < 20; i++) {
            Connection connection = DBCPUtil.getConnection();
            System.out.println(connection+"---"+i);
        }
    }
    @Test
    public void t3(){
        for (int i = 0; i < 50; i++) {
            System.out.println(DBCPUtil.getConnection()+"--"+i);
        }
    }
}
