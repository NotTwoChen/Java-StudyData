package com.wsh.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class PerfectQueryRunner extends QueryRunner {
    public PerfectQueryRunner() {
    }
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.beginTransaction();
        int[] batch = super.batch(connection, sql, params);
        JdbcUtils.commitTransaction();
        JdbcUtils.releaseConnection(connection);
        return batch;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.beginTransaction();
        T query = super.query(connection, sql, rsh, params);
        JdbcUtils.commitTransaction();
        JdbcUtils.releaseConnection(connection);
        return query;
    }
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.beginTransaction();
        T query = super.query(connection, sql, rsh);
        JdbcUtils.commitTransaction();
        JdbcUtils.releaseConnection(connection);
        return query;
    }
    @Override
    public int update(String sql) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.beginTransaction();
        int update = super.update(connection, sql);
        JdbcUtils.commitTransaction();
        JdbcUtils.releaseConnection(connection);
        return update;
    }
    @Override
    public int update(String sql, Object param) throws SQLException {
        return update(sql,param,null);
    }
    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.beginTransaction();
        int update = super.update(connection, sql, params);
        JdbcUtils.commitTransaction();
        JdbcUtils.releaseConnection(connection);
        return update;
    }
}