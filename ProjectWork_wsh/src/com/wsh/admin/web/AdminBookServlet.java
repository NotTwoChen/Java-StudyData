package com.wsh.admin.web;

import com.wsh.book.domain.Book;
import com.wsh.book.service.BookService;
import com.wsh.category.domain.Category;
import com.wsh.category.service.CategoryService;
import com.wsh.user.web.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminBookServlet",urlPatterns = "/adminBook")
public class AdminBookServlet extends BaseServlet {
    private BookService bs = new BookService();
    private CategoryService cs = new CategoryService();
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Book> bookList = bs.queryAll();
        request.setAttribute("bookList",bookList);
        return "f:/adminjsps/admin/book/list.jsp";
    }
    public String load(HttpServletRequest request, HttpServletResponse response){
        String bid = request.getParameter("bid");
        Book book = bs.queryByBid(bid);
        List<Category> categoryList = cs.findAll();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("book",book);
        return "f:/adminjsps/admin/book/desc.jsp";
    }
    public String addPre(HttpServletRequest request, HttpServletResponse response){
        List<Category> categoryList = cs.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/adminjsps/admin/book/add.jsp";
    }
    public String del(HttpServletRequest request, HttpServletResponse response){
        String bid = request.getParameter("bid");
        bs.updateDelByBid(bid);
        List<Book> bookList = bs.queryAll();
        request.setAttribute("bookList",bookList);
        return "f:/adminjsps/admin/book/list.jsp";
    }
    public String mod(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,map);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        bs.updateBook(book);
        List<Book> bookList = bs.queryAll();
        request.setAttribute("bookList",bookList);
        return "f:/adminjsps/admin/book/list.jsp";
    }

}
