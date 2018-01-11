package com.wsh.book.web;

import com.wsh.book.domain.Book;
import com.wsh.book.service.BookService;
import com.wsh.user.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bs = new BookService();
    // 查询所有分类书籍信息
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        List<Book> bookList = bs.queryByPage(page);
        int pages = bs.queryAll().size() / 12 + 1;
        request.setAttribute("page",page);
        request.setAttribute("pages",pages);
        request.setAttribute("bookList",bookList);
        return "f:/jsps/book/list.jsp";
    }
    // 根据参数cid查询对应分类书籍信息
    public String findByCid(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        List<Book> bookList = bs.queryByCid(cid);
        request.setAttribute("bookList",bookList);
        return "f:/jsps/book/list.jsp";
    }
    // 根据参数bid查询对应书籍信息
    public String load(HttpServletRequest request ,HttpServletResponse response){
        String bid = request.getParameter("bid");
        Book book = bs.queryByBid(bid);
        request.setAttribute("book",book);
        return "f:/jsps/book/desc.jsp";
    }
}
