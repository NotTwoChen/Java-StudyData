import com.sun.mail.imap.protocol.ListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "")
public class ShowServlet extends HttpServlet {

    private List<Book> bookList;

    @Override
    public void init() throws ServletException {
        bookList = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            Book book = new Book("玄门大逃杀" + i, "陈不二" + i, i + "元", "玄幻小说");
            bookList.add(book);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 获得前端给我的当前页码参数
        int pageCode = Integer.parseInt(request.getParameter("pageCode"));
        PageBean pageBean = new PageBean();
        List<Book> bookList;
        if (pageCode*pageBean.getPageSize()>this.bookList.size()){
            bookList = this.bookList.subList((pageCode-1)*pageBean.getPageSize(),this.bookList.size());
        }else {
            bookList = this.bookList.subList((pageCode - 1) * pageBean.getPageSize(), pageCode * pageBean.getPageSize());
        }
        pageBean.setTotalData(201);
        System.out.println(pageBean.getTotalPages());
        pageBean.setBookList(bookList);
        pageBean.setPageCode(pageCode);
        request.setAttribute("pageBean", pageBean);
//        response.getWriter().write(Arrays.toString(bookList.toArray()));
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
