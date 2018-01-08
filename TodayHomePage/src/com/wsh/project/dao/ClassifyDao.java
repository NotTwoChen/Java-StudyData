package com.wsh.project.dao;

import com.wsh.project.bean.Classify;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ClassifyDao {

    public Classify queryByClassname(String classname){
        Classify classify = new Classify();
        try {
            classify = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from classify where classname=?",
                    new BeanHandler<Classify>(Classify.class),
                    classname
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classify;
    }
}
