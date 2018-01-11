package com.wsh.user.web;

import com.wsh.cart.domain.Cart;
import com.wsh.user.domain.User;
import com.wsh.user.service.UserService;
import com.wsh.user.service.exception.*;
import com.wsh.util.Activate;
import com.wsh.util.GetUUID;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    private UserService us = new UserService();
    private Activate activate = new Activate();
    // 用户注册
    public String register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, MessagingException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User form = new User();
        BeanUtils.populate(form,parameterMap);
        String uid = new GetUUID().getUUID();
        String code = uid+new GetUUID().getUUID();
        form.setUid(uid);
        form.setCode(code);
        form.setState(0);
        String message = null;
        try {
            us.checkFormat(form);
            us.register(form);
        } catch (RegisterException e) {
            message = e.getMessage();
        } finally {
            if (message != null){
                request.setAttribute("message",message);
                request.setAttribute("form",form);
                return "f:/jsps/user/register.jsp";
            }
        }
        activate.sendEmail(form.getCode(),form.getEmail());
        return "r:/jsps/user/login.jsp";
    }
    // 账号激活
    public String active(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        String message = null;
        try {
            us.active(code);
        } catch (RegisterException e) {
            message = e.getMessage();
        }finally {
            if (message == null) {
                message = "账户已激活成功!~";
            }
        }
        request.setAttribute("message",message);
        return "r:/jsps/msg.jsp";
    }
    // 用户登录
    public String login(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User form = new User();
        BeanUtils.populate(form,parameterMap);
        User user = new User();
        String message = null;
        try {
            user = us.login(form);
        } catch (UsernameNotExistException e) {
            message = e.getMessage();
        } catch (PasswordErrorException e) {
            message = e.getMessage();
        } catch (UserNotActiveException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
                request.setAttribute("form",form);
                return "f:/jsps/user/login.jsp";
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("cart",new Cart());
        return "r:/jsps/main.jsp";
    }
    // 用户退出
    public String quit(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "r:/jsps/user/login.jsp";
    }
}
