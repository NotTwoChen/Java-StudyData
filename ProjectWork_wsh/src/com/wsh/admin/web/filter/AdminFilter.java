package com.wsh.admin.web.filter;

import com.wsh.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = {"/cart","/order","/category"})
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            chain.doFilter(req, resp);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/jsps/body.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
