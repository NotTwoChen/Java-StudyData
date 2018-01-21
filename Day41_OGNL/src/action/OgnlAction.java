package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class OgnlAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    private String name = "哦哦哦";

//    public String getName() {
//        return name;
//    }

    public String hello(){
        System.out.println("hello");
        return SUCCESS;
    }
    public String show(){
        ActionContext context = ActionContext.getContext();
        context.put("show","嚯嚯嚯");
        return SUCCESS;
    }
    public String el(){
//        ActionContext.getContext().put("name","屁几万");
        ActionContext.getContext().getSession().put("name","做头发");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        request = httpServletRequest;
    }
}
