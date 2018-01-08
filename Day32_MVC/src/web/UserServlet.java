package web;

import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("login被调用了");
        // 封装重定向/请求转发
        // 应该指定一个路径,还得让父类BaseServlet能获得
        return "r:/index.jsp";
    }
    public String register(HttpServletRequest request, HttpServletResponse response){
        System.out.println("register被调用了");
//        request.getRequestDispatcher()请求转发
//        response.sendRedirect()       重定向
        // f:表示请求转发
        // r:表示重定向
        return "f:/login.jsp";
    }
    public String update(HttpServletRequest request, HttpServletResponse response){
        System.out.println("update被调用了");
        return "";
    }
    public String exit(HttpServletRequest request, HttpServletResponse response){
        System.out.println("exit被调用了");
        return "";
    }
}
