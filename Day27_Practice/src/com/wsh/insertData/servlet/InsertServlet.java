package com.wsh.insertData.servlet;

import com.wsh.queryTable.dao.UserData;
import com.wsh.queryTable.util.JdbcUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

public class InsertServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        UserData userData = new UserData();
        try {
            JdbcUtil.getJdbcUtil(this.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc.properties"));
            BeanUtils.populate(userData,parameterMap);
            JdbcUtil.insertUserDataForSql(userData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("SUCCESS");

    }
}
