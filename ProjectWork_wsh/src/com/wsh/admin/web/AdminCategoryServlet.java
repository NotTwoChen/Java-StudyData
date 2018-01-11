package com.wsh.admin.web;

import com.wsh.category.domain.Category;
import com.wsh.category.service.CategoryService;
import com.wsh.category.service.exception.CategoryDeleteErrorException;
import com.wsh.category.service.exception.CategoryExitException;
import com.wsh.category.service.exception.CategoryInsertErrorException;
import com.wsh.category.service.exception.CategoryUpdateErrorException;
import com.wsh.user.web.BaseServlet;
import com.wsh.util.GetUUID;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/adminCategory")
public class AdminCategoryServlet extends BaseServlet{
    private CategoryService cs = new CategoryService();
    // 查找所有分类信息
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Category> categoryList = cs.findAll();
        request.setAttribute("categoryList",categoryList);
        return "f:/adminjsps/admin/category/list.jsp";
    }
    // 添加分类
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String cname = request.getParameter("cname");
        String uuid = new GetUUID().getUUID();
        Category category = new Category(uuid, cname);
        String message = null;
        try {
            cs.insert(category);
        } catch (CategoryInsertErrorException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
                return "f:/adminjsps/admin/msg.jsp";
            }
        }
        return findAll(request,response);
    }
    // 删除分类
    public String delete(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        String message = null;
        try {
            cs.delete(cid);
        } catch (CategoryDeleteErrorException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
                return "f:/adminjsps/admin/msg.jsp";
            }
        }
        return findAll(request,response);
    }
    // 查找不同分类信息
    public String editPre(HttpServletRequest request, HttpServletResponse response) throws CategoryExitException {
        String cid = request.getParameter("cid");
        Category category = cs.queryByCid(cid);
        request.setAttribute("category",category);
        return "f:/adminjsps/admin/category/mod.jsp";
    }
    // 修改分类信息
    public String edit(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = request.getParameterMap();
        Category category = new Category();
        BeanUtils.populate(category,map);
        String message = null;
        try {
            cs.updateCategory(category);
        } catch (CategoryUpdateErrorException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
                return "f:/adminjsps/admin/msg.jsp";
            }
        }
        return findAll(request,response);
    }
}
