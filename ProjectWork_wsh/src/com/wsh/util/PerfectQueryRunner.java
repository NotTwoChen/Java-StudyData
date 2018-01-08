package com.wsh.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class PerfectQueryRunner extends QueryRunner {
    public PerfectQueryRunner() {
    }
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T query = super.query(connection, sql, rsh, params);
        JdbcUtils.releaseConnection(connection);
        return query;
    }
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T query = super.query(connection, sql, rsh);
        JdbcUtils.releaseConnection(connection);
        return query;
    }
    @Override
    public int update(String sql) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int update = super.update(connection, sql);
        JdbcUtils.releaseConnection(connection);
        return update;
    }
    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int update = super.update(connection, sql, param);
        JdbcUtils.releaseConnection(connection);
        return update;
    }
    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int update = super.update(connection, sql, params);
        JdbcUtils.releaseConnection(connection);
        return update;
    }
}
