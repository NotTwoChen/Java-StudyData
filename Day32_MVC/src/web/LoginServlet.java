package web;

import domain.User;
import service.UserService;
import service.exception.LoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User formUser = new User(username, password);
        try {
            User login = userService.login(formUser);
            request.getSession().setAttribute("user",login);
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        } catch (LoginException e) {
            request.setAttribute("errorMsg",e.getMessage());
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
