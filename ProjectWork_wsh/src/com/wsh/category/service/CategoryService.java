package com.wsh.category.service;

import com.wsh.category.dao.CategoryDao;
import com.wsh.category.domain.Category;
import com.wsh.category.service.exception.CategoryDeleteErrorException;
import com.wsh.category.service.exception.CategoryExitException;
import com.wsh.category.service.exception.CategoryInsertErrorException;
import com.wsh.category.service.exception.CategoryUpdateErrorException;

import java.util.List;

public class CategoryService {
    private CategoryDao cd = new CategoryDao();
    // 查询所有分类信息
    public List<Category> findAll(){
        return cd.queryAll();
    }
    // 调用Dao方法,如果返回值为0,则添加分类失败,抛出异常信息
    public void insert(Category category) throws CategoryInsertErrorException {
        int insert = cd.insert(category);
        if (insert == 0){ throw new CategoryInsertErrorException(); }
    }
    // 调用Dao方法,得到对应分类下书籍数目,如果数目大于0,则抛出分类不可删除异常
    public void delete(String cid) throws CategoryDeleteErrorException {
        long books = cd.queryBookCountByCid(cid);
        if (books > 0){
            throw new CategoryDeleteErrorException();
        }
        int delete = cd.delete(cid);
        if (delete == 0){
            throw new CategoryDeleteErrorException();
        }
    }
    // 根据参数cid查询对应分类信息,如果返回的category对象为空,则抛出分类不存在异常
    public Category queryByCid(String cid) throws CategoryExitException {
        Category category = cd.queryByCid(cid);
        if (category == null){ throw new CategoryExitException(); }
        return category;
    }
    // 根据参数Category对象修改分类信息,如果返回值为0,则说明分类信息修改失败
    public void updateCategory(Category category) throws CategoryUpdateErrorException {
        int update = cd.updateCategory(category);
        if (update == 0){ throw new CategoryUpdateErrorException(); }
    }
}
