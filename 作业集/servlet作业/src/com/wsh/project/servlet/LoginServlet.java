package com.wsh.project.servlet;

import com.wsh.project.bean.UserData;
import com.wsh.project.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<UserData> query = userDao.query();
        for (UserData userData : query) {
            if (userData.getUsername().equals(username)){
                if (userData.getPassword().equals(password)){
                    String name = userData.getName();
                    if (name == null){
                        name = "用户名未定义";
                    }
                    getServletContext().setAttribute("name",name);
                    response.sendRedirect("home.html");
                    break;
                }else {
                    response.sendRedirect("login.html");
                }
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Object name = getServletContext().getAttribute("name");
        response.getWriter().write(name.toString());
    }
}
