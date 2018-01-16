package servletapi;

import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

public class ApiAction extends ActionSupport {

    public String api(){
        System.out.println("Api类中的api方法已经被执行!~");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("名字"+i,i);
            users.add(user);
        }
        ServletActionContext.getRequest().setAttribute("users",users);
        return SUCCESS;
    }
}
