package com.wsh.homework;

import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class PracticeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ServletContext context = this.getServletContext();
        Properties properties = new Properties();
        properties.load(context.getResourceAsStream("/WEB-INF/classes/jdbc.properties"));
        String driverName = properties.getProperty("driverName");
        String url = properties.getProperty("url");
        String database = properties.getProperty("database");
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        List<UserData> query = null;
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url + database, username, password);
            query = new NewQueryRunner().query(
                    connection,
                    "select * From userdata",
                    new BeanListHandler<UserData>(UserData.class)
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = JSONArray.fromObject(query);
        resp.getWriter().write(jsonArray.toString());


    }
}
