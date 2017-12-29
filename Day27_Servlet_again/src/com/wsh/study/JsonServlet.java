package com.wsh.study;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JsonServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 每次一接受到请求,就返回一个JSON数据
        List<User> users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername("user:"+i);
            user.setGender(random.nextBoolean()?"男":"女");
            user.setAge(i+"");
            users.add(user);
        }
        // 使用json-lib包中的工具类
        // 将集合users转换成一个JSON数组
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
