package com.wsh.user.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public BaseServlet() {
    }
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String methodName = request.getParameter("method");
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception var10) {
            throw new RuntimeException("您要调用的方法：" + methodName + "它不存在！", var10);
        }

        try {
            String result = (String)method.invoke(this, request, response);
            if (result != null && !result.trim().isEmpty()) {
                int index = result.indexOf(":");
                if (index == -1) {
                    request.getRequestDispatcher(result).forward(request, response);
                } else {
                    String start = result.substring(0, index);
                    String path = result.substring(index + 1);
                    if (start.equals("f")) {
                        request.getRequestDispatcher(path).forward(request, response);
                    } else if (start.equals("r")) {
                        response.sendRedirect(request.getContextPath() + path);
                    }
                }
            }
        } catch (Exception var9) {
            throw new RuntimeException(var9);
        }
    }
}
