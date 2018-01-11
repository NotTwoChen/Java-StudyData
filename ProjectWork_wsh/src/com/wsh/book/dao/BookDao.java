package com.wsh.book.dao;

import com.wsh.book.domain.Book;
import com.wsh.util.PerfectQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private PerfectQueryRunner pqr = new PerfectQueryRunner();
    // 查询所有书籍信息并返回书籍信息集合
    public List<Book> queryAll(){
        String sql = "SELECT * FROM book WHERE del=0";
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = pqr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    // 根据参数cid查询所有相同分类的书籍信息并返回书籍信息集合
    public List<Book> queryByCid(String cid){
        String sql = "SELECT * FROM book WHERE cid=? AND del=0";
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = pqr.query(sql, new BeanListHandler<Book>(Book.class), cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    // 根据参数bid查询书籍信息并返回书籍实体类实例化对象
    public Book queryByBid(String bid){
        String sql = "SELECT * FROM book WHERE bid=? AND del=0";
        Book book = new Book();
        try {
            book = pqr.query(sql, new BeanHandler<Book>(Book.class), bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    // 将参数book对象添加到数据库中
    public void insert(Book book){
        String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,0)";
        try {
            pqr.update(
                    sql,
                    book.getBid(),
                    book.getBname(),
                    book.getPrice(),
                    book.getAuthor(),
                    book.getImage(),
                    book.getCid()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 根据参数bid找到对应书籍并将之del字段状态改为1(即被删除状态)
    public void updateDelByBid(String bid){
        String sql = "UPDATE book SET del=1 WHERE bid=?";
        try {
            pqr.update(sql, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 根据参数book对象将相应对象属性修改到数据库中
    public void updateBook(Book book){
        String sql = "UPDATE book SET bname=?,price=?,author=?,cid=? WHERE bid=? AND del=0";
        try {
            pqr.update(
                    sql,
                    book.getBname(),
                    book.getPrice(),
                    book.getAuthor(),
                    book.getCid(),
                    book.getBid()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
