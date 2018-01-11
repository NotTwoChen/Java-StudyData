package com.wsh.book.service;

import com.wsh.book.dao.BookDao;
import com.wsh.book.domain.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDao bd = new BookDao();
    // 查询所有书籍信息并返回书籍信息集合
    public List<Book> queryAll(){
        return bd.queryAll();
    }
    // 根据参数cid查询所有相同分类的书籍信息并返回书籍信息集合
    public List<Book> queryByCid(String cid){
        return bd.queryByCid(cid);
    }
    // 根据参数bid查询书籍信息并返回书籍实体类实例化对象
    public Book queryByBid(String bid){
        return bd.queryByBid(bid);
    }
    // 将参数book对象添加到数据库中
    public void insert(Book book){
        bd.insert(book);
    }
    // 根据参数bid找到对应书籍并将之del字段状态改为1(即被删除状态)
    public void updateDelByBid(String bid){
        bd.updateDelByBid(bid);
    }
    // 根据参数book对象将相应对象属性修改到数据库中
    public void updateBook(Book book){
        bd.updateBook(book);
    }
    // 根据参数page查询相应书籍信息
    public List<Book> queryByPage(int page){
        int start = 12*(page-1);
        int end = 12*page;
        List<Book> bookList = queryAll();
        if (start > bookList.size()){
            start = bookList.size();
        }
        if (end > bookList.size()){
            end = bookList.size();
        }
        List<Book> bookSubList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            bookSubList.add(bookList.get(i));
        }
        return bookSubList;
    }
}
