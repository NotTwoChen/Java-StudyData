package com.wsh.study;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ExecuteInter {

    Statement execute(Connection connection) throws SQLException;
}
