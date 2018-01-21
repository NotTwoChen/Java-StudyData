package action;

import com.opensymphony.xwork2.ActionSupport;

public class GlobalResultAction extends ActionSupport {

    public  String show(){
        System.out.println("请求转发到:show.jsp页面");
        return "show";
    }
}
