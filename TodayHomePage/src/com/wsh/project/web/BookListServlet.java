package com.wsh.project.web;

import com.wsh.project.bean.Book;
import com.wsh.project.dao.BookDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet",urlPatterns = "/book")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bidSt = request.getParameter("bid");
        int bid = Integer.decode(bidSt);
        Book book = new BookDao().query(bid);
        JSONObject jsonObject = JSONObject.fromObject(book);
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Book> bookList = new BookDao().query();
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        response.getWriter().write(jsonArray.toString());
    }
}
