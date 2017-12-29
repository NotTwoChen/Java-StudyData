package com.wsh.project.tool;

import com.wsh.project.QueryRunner.NewQueryRunner;
import com.wsh.project.dao.UserData;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Instrument {


    public static List<UserData> query(){

        try {
            List<UserData> query = new NewQueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from userdata",
                    new BeanListHandler<UserData>(UserData.class)
            );
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int insert(UserData userData){
        try {
            int update = new NewQueryRunner().update(
                    JdbcUtil.getConnection(),
                    "insert into userdata values(?,?,?)",
                    userData.getName(),
                    userData.getUsername(),
                    userData.getPassword()
            );
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
