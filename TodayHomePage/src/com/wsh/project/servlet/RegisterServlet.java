package com.wsh.project.servlet;

import com.wsh.project.bean.UserData;
import com.wsh.project.dao.UserDao;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserData userData = new UserData();
        try {
            BeanUtils.populate(userData,parameterMap);
            if (UserDao.insert(userData) > 0){
                response.sendRedirect("login.html");
            }else {
                response.sendRedirect("register.html");
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<UserData> query = UserDao.query();
        if (query != null){
            JSONArray jsonArray = JSONArray.fromObject(query);
            response.getWriter().write(jsonArray.toString());
        }
    }
}
