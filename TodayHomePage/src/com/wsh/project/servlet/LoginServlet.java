package com.wsh.project.servlet;

import com.wsh.project.dao.UserData;
import com.wsh.project.tool.Instrument;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<UserData> query = Instrument.query();
        JSONArray jsonArray = JSONArray.fromObject(query);
        resp.getWriter().write(jsonArray.toString());
    }
}
