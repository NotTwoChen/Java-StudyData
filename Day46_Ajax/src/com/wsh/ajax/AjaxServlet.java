package com.wsh.ajax;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxServlet" ,urlPatterns = "/show")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        String[] array = {"abc","asdasd","asdasd","asdsd","asdasdasd"};
        String input = request.getParameter("input");
        System.out.println(input);
        List<String> list = new ArrayList<>();
        if (input == null){
            return;
        }
        for (String s : array) {
            if (s.startsWith(input)){
                list.add(s);
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(list);

        response.getWriter().write(jsonArray.toString());
    }
}
