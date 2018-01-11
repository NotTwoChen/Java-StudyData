package com.wsh.admin.web;

import com.wsh.user.domain.User;
import com.wsh.user.service.UserService;
import com.wsh.user.service.exception.AdminPasswordErrorException;
import com.wsh.user.service.exception.AdminnameExitException;
import com.wsh.user.service.exception.LoginException;
import com.wsh.user.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends BaseServlet {
    private UserService us = new UserService();
    public String login(HttpServletRequest request, HttpServletResponse response){
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");
        String message = null;
        User admin = new User();
        try {
            admin = us.checkstate(adminname, password);
        } catch (LoginException e) {
            message = e.getMessage();
        } finally {
            if (message != null){
                request.setAttribute("message",message);
                return "f:/adminjsps/msg.jsp";
            }
        }
        request.getSession().setAttribute("admin",admin);
        return "f:/adminjsps/admin/main.jsp";
    }
}
