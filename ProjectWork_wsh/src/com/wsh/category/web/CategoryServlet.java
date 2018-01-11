package com.wsh.category.web;

import com.wsh.category.domain.Category;
import com.wsh.category.service.CategoryService;
import com.wsh.user.web.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    private CategoryService cs = new CategoryService();
    // 查询所有分类
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Category> categoryList = cs.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/jsps/left.jsp";
    }
}
