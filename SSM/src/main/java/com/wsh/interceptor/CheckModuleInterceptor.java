package com.wsh.interceptor;

import com.wsh.role.domain.ModuleInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckModuleInterceptor implements HandlerInterceptor {
    @Override
    @SuppressWarnings("unchecked")
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        List<ModuleInfo> modules = (List<ModuleInfo>) httpServletRequest.getSession().getAttribute("allModules");
        Integer currentModule = (Integer) httpServletRequest.getSession().getAttribute("currentModule");
        for (ModuleInfo module : modules) {
            if (module.getModuleId().equals(currentModule)){
                return true;
            }
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/nopower");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
