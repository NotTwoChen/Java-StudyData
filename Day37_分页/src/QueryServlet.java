import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "QueryServlet",urlPatterns = "/show")
public class QueryServlet extends HttpServlet {
    private PageBean pageBean = new PageBean();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;character=utf-8");
        String code = request.getParameter("pageCode");
        if (code == null){
            code = "1";
        }
        System.out.println("1"+code);
        int pageCode = Integer.parseInt(code);
        pageBean.setPageCode(pageCode);
        int pageSize = pageBean.getPageSize();
        int begin = (pageCode - 1) * pageSize;
        int end = pageCode * pageSize;
        Map<String,String> map = new HashMap<>();

        map.put("bookName",request.getParameter("bookName"));
        map.put("author",request.getParameter("author"));
        map.put("price",request.getParameter("price"));
        map.put("category",request.getParameter("category"));
        System.out.println(map.toString()+"+++++++++");

        StringBuilder sb = new StringBuilder("select * from book");
        String params = "";
        System.out.println("2"+params);
        boolean shouldAnd = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")){
                System.out.println(entry.getKey() + "3----" + entry.getValue()+"----");
                if (shouldAnd){
                    sb.append(" where " + entry.getKey() + "='" + entry.getValue() + "'");
                    System.out.println("4"+sb.toString());
                    shouldAnd = false;
                }else {
                    sb.append(" and " + entry.getKey() + "='" + entry.getValue() + "'");
                    System.out.println("5"+sb.toString());
                }
                params = params + "&" + entry.getKey() + "=" + entry.getValue();
                System.out.println("6"+params);
            }
        }
        pageBean.setParams(params);

        sb.append(" limit " + begin + "," + end);
        System.out.println("7"+sb.toString());

        List<Book> bookList = new ArrayList<>();
        try {
            bookList = new QueryRunner().query(JdbcUtil.getConnection(),sb.toString(),new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setBookList(bookList);
        pageBean.setTotalData(101);

        request.setAttribute("pageBean",pageBean);
        System.out.println(pageBean.toString()+pageBean.getTotalPages());

        JSONObject jsonObject = JSONObject.fromObject(pageBean);
        response.getWriter().write(jsonObject.toString());

//        String code = request.getParameter("pageCode");
//        if (code == null){
//            code = "1";
//        }
//        int pageCode = Integer.parseInt(code);
//
//        String bookName = request.getParameter("bookName");
//        String author = request.getParameter("author");
//        String price = request.getParameter("price");
//        String category = request.getParameter("category");
//
//
//        StringBuilder sb = new StringBuilder();
//        String params = "";
//        String[] pn = {"bookName","author","price","category"};
//        String[] pm = {bookName,author,price,category};
//
//        sb.append("select * from book");
//        if (bookName != null || author != null || price != null || category != null){
//            sb.append(" where ");
//            boolean shouAnd = false;
//            for (int i = 0; i < pn.length; i++) {
//                if (pm[i] != null){
//                    if (shouAnd){
//                        sb.append(" and ");
//                    }
//                    sb.append(pn[i]+"="+"'"+pm[i]+"'");
//                    if (!pm[i].equals("")){
//                        params += "&" + pn[i] + "=" + pm[i];
//                    }
//                    shouAnd = true;
//                }
//            }
//        }
//        sb.append(" limit " + (pageCode-1)*pageBean.getPageSize() + ","+pageBean.getPageSize());
//        Connection connection = JdbcUtil.getConnection();
//        List<Book> query = new ArrayList<>();
//        try {
//            query = new QueryRunner().query(connection, sb.toString(), new BeanListHandler<Book>(Book.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        pageBean.setPageCode(pageCode);
//        pageBean.setParams(params);
//        pageBean.setBookList(query);
//        pageBean.setTotalData(pageCode*pageBean.getPageSize());
//        request.setAttribute("pageBean",pageBean);
//        JSONObject jsonObject = JSONObject.fromObject(pageBean);
//        response.setContentType("application/json");
//        response.getWriter().write(jsonObject.toString());

    }
}
