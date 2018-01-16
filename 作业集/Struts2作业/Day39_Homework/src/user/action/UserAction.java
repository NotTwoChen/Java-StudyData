package user.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import user.bean.User;
import user.service.UserService;
import user.service.exception.LoginException;
import user.service.exception.PasswordErrorException;
import user.service.exception.UserExistsException;
import user.service.exception.UserNoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
    private static UserService us = new UserService();
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        response = httpServletResponse;
    }

    public String register(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        String message = null;
        try {
            us.register(user);
        } catch (UserExistsException e) {
            message = e.getMessage();
        }finally {
            if (message != null){
                request.setAttribute("message",message);
                return ERROR;
            }
        }
        return SUCCESS;
    }
    public String login(){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        String message = null;
        try {
            us.login(user);
        } catch (LoginException e) {
            message = e.getMessage();
        } finally {
            if (message != null){
                request.setAttribute("message",message);
                return ERROR;
            }
        }
        return SUCCESS;
    }
}
