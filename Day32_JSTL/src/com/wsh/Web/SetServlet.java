package com.wsh.Web;

import com.wsh.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SetServlet",urlPatterns = "/set")
public class SetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("下面有请"+i+"号男嘉宾");
            user.setGender("男");
            users.add(user);
        }
        request.setAttribute("users",users);
        request.getRequestDispatcher("2_core.jsp").forward(request,response);
    }
}
