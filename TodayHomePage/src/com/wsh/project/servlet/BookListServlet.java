package com.wsh.project.servlet;

import com.wsh.project.bean.Book;
import com.wsh.project.dao.BookDao;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookListServlet",urlPatterns = "/book")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        BeanUtils.populate(book,parameterMap);
        

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Book> bookList = new BookDao().query();
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        response.getWriter().write(jsonArray.toString());
    }
}
