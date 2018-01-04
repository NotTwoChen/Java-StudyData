package com.wsh.project.dao;

import com.wsh.project.bean.Book;
import com.wsh.project.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao{

    public List<Book> query(){
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from book",
                    new BeanListHandler<Book>(Book.class)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book query(int bid){
        Book book = new Book();
        try {
            book = new QueryRunner().query(
                    JdbcUtil.getConnection(),
                    "select * from book where bid = ?",
                    new BeanHandler<Book>(Book.class),
                    bid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public int insert(Book book){
        int update = 0;
        try {
            update = new QueryRunner().update(
                    JdbcUtil.getConnection(),
                    "insert into book values(null,?,?,?,?,?)",
                    book.getBname(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getCover(),
                    book.getContent()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

}
