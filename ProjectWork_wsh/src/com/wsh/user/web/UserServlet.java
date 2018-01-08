package com.wsh.user.web;

import com.wsh.user.dao.UserDao;
import com.wsh.user.domain.User;
import com.wsh.user.service.UserService;
import com.wsh.user.service.exception.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService us = new UserService();
    public UserServlet() {
    }
    //f:表示请求转发
    //r:表示重定向
    public String register(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        User form = new User();
        try {
            BeanUtils.populate(form,parameterMap);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        String uid = us.getUUID();
        form.setUid(uid);
        String code = uid+us.getUUID();
        form.setCode(code);
        form.setState(0);
        try {
            us.checkFormat(form);
        } catch (UsernameFormatErrorException e) {
            e.printStackTrace();
            e.getMessage();//
        } catch (PasswordFormatErrorException e) {
            e.printStackTrace();
            e.getMessage();//
        } catch (EmailFormatErrorException e) {
            e.printStackTrace();
            e.getMessage();//
        }
        try {
            us.register(form);
        } catch (EmailHasBeenRegisteredException e) {
            e.printStackTrace();
            e.getMessage();//
        } catch (UsernameHasBeenRegisteredException e) {
            e.printStackTrace();
            e.getMessage();//
        }
        try {
            us.sendEmail(form.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("我进来了");
        return "r:/index.jsp";
    }
    public String activate(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        int update = new UserDao().update(code);
        if (update > 0){
            System.out.println("激活成功!");

        }
        // TODO 已经解决到邮箱激活成功的一步了
        return "r:/index.jsp";
    }


    public String login(HttpServletRequest request, HttpServletResponse response){

        return "r:/index.jsp";
    }

}
