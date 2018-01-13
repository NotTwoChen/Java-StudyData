package com.wsh.book.web;

import com.wsh.book.domain.Book;
import com.wsh.book.domain.PageBean;
import com.wsh.book.service.BookService;
import com.wsh.user.web.BaseServlet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bs = new BookService();
    // 查询所有分类书籍信息
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        List<Book> bookList = bs.queryByPage(bs.queryAll(),page);
        int size = bs.queryAll().size();
        int pages = size % 12 > 0 ? size / 12 + 1 : size / 12;
        request.setAttribute("page",page);
        request.setAttribute("pages",pages);
        request.setAttribute("bookList",bookList);
        return "f:/jsps/book/list.jsp";
    }
    // 根据参数cid查询对应分类书籍信息
    public String findByCid(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        String cid = request.getParameter("cid");
        List<Book> bookList = bs.queryByPage(bs.queryByCid(cid), page);
        int size = bs.queryByCid(cid).size();
        int pages = size % 12 > 0 ? size / 12 + 1 : size / 12;
        request.setAttribute("page",page);
        request.setAttribute("pages",pages);
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
    //
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;character=utf-8");
        String page = request.getParameter("pageCode");
        if (page == null){
            page = "1";
        }
        int pageCode = Integer.parseInt(page);
        String cid = request.getParameter("cid");
        PageBean<Book> pageBean = bs.queryByPage(cid,pageCode, 4);
        JSONObject jsonObject = JSONObject.fromObject(pageBean);
        response.getWriter().write(jsonObject.toString());
    }
}
