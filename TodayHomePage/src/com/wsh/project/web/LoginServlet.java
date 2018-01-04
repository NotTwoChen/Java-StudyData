package com.wsh.project.web;

import com.wsh.project.bean.User;
import com.wsh.project.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User query = UserDao.query(username);
        if (query != null){
            if (query.getPassword().equals(password)){
                if (query.getName() == null) {
                    query.setName(query.getUsername()+"(昵称未定义)");
                }
                Cookie cookie_name = new Cookie("name",query.getName());
                Cookie cookie_username = new Cookie("username", query.getUsername());
                cookie_name.setPath("/TodayHomePage/login");
                cookie_username.setPath("/TodayHomePage/login");
                cookie_name.setMaxAge(60*60*24*30);
                cookie_username.setMaxAge(60*60*24*30);
                response.addCookie(cookie_name);
                response.addCookie(cookie_username);

                HttpSession session = request.getSession();
                session.setAttribute("name",query.getName());
                session.setAttribute("username",query.getUsername());
                session.setAttribute("password",query.getPassword());
                response.sendRedirect("index.jsp");
                return;
            }
        }
            response.sendRedirect("login.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                request.getSession().removeAttribute("name");
                request.getSession().removeAttribute("username");
                request.getSession().removeAttribute("password");
                response.getWriter().write(cookie.getValue());
                return;
            }
        }


    }
}
