package com.wsh.work.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wsh.work.bean.User;
import org.apache.struts2.ServletActionContext;

public class Interceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user != null){
            return actionInvocation.invoke();
        }
        return "error";
    }
}
