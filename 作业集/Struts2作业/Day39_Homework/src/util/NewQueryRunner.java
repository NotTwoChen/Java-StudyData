package util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class NewQueryRunner extends QueryRunner {
    private static C3p0Utils c3p0Utils = new C3p0Utils();
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection connection = c3p0Utils.getConnection();
        int[] batch = super.batch(connection, sql, params);
        c3p0Utils.closeConnection();
        return batch;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = c3p0Utils.getConnection();
        T query = super.query(connection, sql, rsh, params);
        c3p0Utils.closeConnection();
        return query;
    }
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = c3p0Utils.getConnection();
        T query = super.query(connection, sql, rsh);
        c3p0Utils.closeConnection();
        return query;
    }
    @Override
    public int update(String sql) throws SQLException {
        Connection connection = c3p0Utils.getConnection();
        int update = super.update(connection, sql);
        c3p0Utils.closeConnection();
        return update;
    }
    @Override
    public int update(String sql, Object param) throws SQLException {
        return update(sql,param,null);
    }
    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = c3p0Utils.getConnection();
        int update = super.update(connection, sql, params);
        c3p0Utils.closeConnection();
        return update;
    }
}
