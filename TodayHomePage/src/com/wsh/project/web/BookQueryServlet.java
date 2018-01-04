package com.wsh.project.web;

import com.wsh.project.bean.Book;
import com.wsh.project.dao.BookDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BookQueryServlet",urlPatterns = "/query")
public class BookQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bookInfo = request.getParameter("bookInfo");
        List<Book> bookList = new BookDao().queryByName(bookInfo);
        if (bookList.size() == 0) {
            bookList = new BookDao().queryByAuthor(bookInfo);
            if (bookList.size() == 0) {
                response.sendRedirect("index.jsp");
                return;
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        response.getWriter().write(jsonArray.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book("","",0,"","");

    }
}
