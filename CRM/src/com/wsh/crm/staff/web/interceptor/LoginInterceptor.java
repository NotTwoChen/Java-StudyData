package com.wsh.crm.staff.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object crmStaff = ActionContext.getContext().getSession().get("crmStaff");
        if (crmStaff == null){
            Object action = actionInvocation.getAction();
            if (action instanceof ActionSupport){
                ActionSupport actionSupport = (ActionSupport) action;
                actionSupport.addFieldError("login","请先登录~!");
            }
            return "login";
        }
        return actionInvocation.invoke();
    }
}
