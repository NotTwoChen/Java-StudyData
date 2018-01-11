package com.wsh.category.dao;

import com.wsh.category.domain.Category;
import com.wsh.util.PerfectQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private static PerfectQueryRunner pqr = new PerfectQueryRunner();
    // 查询所有书籍分类信息并返回实例化Category对象的List集合
    public List<Category> queryAll(){
        String sql = "SELECT * FROM category";
        List<Category> categoryList = new ArrayList<>();
        try {
            categoryList = pqr.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    // 根据参数cid查询该分类下del状态为0的书籍数量
    public long queryBookCountByCid(String cid){
        String sql = "SELECT count(book.cid) FROM category INNER JOIN book ON book.cid = category.cid WHERE category.cid = 1 AND del = 0 GROUP BY category.cid";
        long count = 0;
        try {
            Object query = pqr.query(sql, new ScalarHandler<>(), cid);
            if (query != null){
                count = (long) query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    // 将category实体类实例化对象数据存进数据库中
    public int insert(Category category){
        String sql = "INSERT INTO category VALUES(?,?)";
        int update = 0;
        try {
            update = pqr.update(
                    sql,
                    category.getCid(),
                    category.getCname()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    // 根据参数cid删除对应数据库分类信息以及分类下del状态为1的书籍
    public int delete(String cid){
        int update = 0;
        String sql = "DELETE FROM book WHERE cid=? AND del=1";
        try {
            update = pqr.update(sql, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "DELETE FROM category WHERE cid=?";
        try {
            update = pqr.update(sql, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    // 根据参数cid查询对应数据库分类信息
    public Category queryByCid(String cid){
        String sql = "SELECT * FROM category WHERE cid=?";
        Category category = new Category();
        try {
            category = pqr.query(sql, new BeanHandler<Category>(Category.class), cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    // 根据参数category对应的cid修改分类名cname
    public int updateCategory(Category category){
        String sql = "UPDATE category SET cname=? WHERE cid=?";
        int update = 0;
        try {
            update = pqr.update(sql, category.getCname(), category.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
