package com.wsh.project.servlet;

import com.wsh.project.bean.UserData;
import com.wsh.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserData query = UserDao.query(username);
        if (query != null){
            if (query.getPassword().equals(password)){
                String name = query.getName();
                if (name == null) {
                    name = query.getUsername()+"(昵称未定义)";
                }
                HttpSession session = request.getSession();
                session.setAttribute("name",name);
                session.setAttribute("username",query.getUsername());
                response.sendRedirect("index.jsp");
                return;
            }
        }
            response.sendRedirect("login.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("name",null);
        String username = (String) session.getAttribute("username");
        response.getWriter().write(username);

    }
}
