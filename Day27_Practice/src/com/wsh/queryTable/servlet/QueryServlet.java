package com.wsh.queryTable.servlet;

import com.wsh.queryTable.dao.UserData;
import com.wsh.queryTable.util.JdbcUtil;
import net.sf.json.JSONArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/jdbc.properties");
            JdbcUtil.getJdbcUtil(resourceAsStream);
            List<UserData> query = JdbcUtil.getListOfQuery();
            JSONArray jsonArray = JSONArray.fromObject(query);
            resp.getWriter().write(jsonArray.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
