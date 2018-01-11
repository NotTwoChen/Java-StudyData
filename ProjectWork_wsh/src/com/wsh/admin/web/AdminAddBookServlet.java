package com.wsh.admin.web;


import com.wsh.book.domain.Book;
import com.wsh.book.service.BookService;
import com.wsh.util.Constant;
import com.wsh.util.GetUUID;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminAddBookServlet",urlPatterns = "/adminAddBook")
public class AdminAddBookServlet extends HttpServlet {
    private BookService bs = new BookService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建解析器工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        factory.setSizeThreshold(1024*1024*3);
        upload.setHeaderEncoding(Constant.ENCODING);
        // 调用解析器解析上传数据
        List<FileItem> list = null;
        try {
            list = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        // 遍历list,得到用于封装第一个上传输入项数据fileItem对象
        Map<String, String> map = new HashMap<>();
        for (FileItem item : list) {
            if (item.isFormField()){
                // 得到的是普通输入项
                String name = item.getFieldName();//得到输入项的名称
                String value = item.getString(Constant.ENCODING);
                map.put(name,value);
            }else {
                // 得到的是上传输入项
                String fileName = item.getName();//得到上传文件名(客户端绝对路径)
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                InputStream inputStream = item.getInputStream();//得到上传数据
                byte[] bytes = new byte[1024*1024*10];
                String realPath = getServletContext().getRealPath("/book_img");
//                    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\lanou3g\\Java-StudyData\\ProjectWork_wsh\\web\\book_img" + "\\" + fileName);//向upload目录中写入文件
                FileOutputStream outputStream = new FileOutputStream(realPath + "\\" + fileName);
                int len = 0;
                while ((len = inputStream.read(bytes))>0){
                    outputStream.write(bytes,0,len);
                }
                map.put("image","book_img/"+fileName);
                map.put("bid",new GetUUID().getUUID());
                inputStream.close();
                outputStream.close();
            }
        }
        Book book = new Book();
        try {
            BeanUtils.populate(book,map);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
//        System.out.println(book.toString());
        bs.insert(book);
        List<Book> bookList = bs.queryAll();
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/adminjsps/admin/book/list.jsp").forward(request,response);
    }
}
