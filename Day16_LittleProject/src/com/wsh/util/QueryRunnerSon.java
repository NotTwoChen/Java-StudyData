package com.wsh.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryRunnerSon extends QueryRunner{

    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {
        conn.setAutoCommit(false);
        T query = super.query(conn, sql, rsh);
        conn.commit();
        conn.close();
        return query;
    }

    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        conn.setAutoCommit(false);
        T query = super.query(conn, sql, rsh, params);
        conn.commit();
        conn.close();
        return query;
    }
}
