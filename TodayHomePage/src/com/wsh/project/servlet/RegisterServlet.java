package com.wsh.project.servlet;

import com.wsh.project.dao.UserData;
import com.wsh.project.tool.Instrument;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        UserData userData = new UserData();
        try {
            BeanUtils.populate(userData,parameterMap);
            if (Instrument.insert(userData) > 0){
                resp.getWriter().write("SUCCESS");
            }else {
                resp.getWriter().write("FAILURE");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
