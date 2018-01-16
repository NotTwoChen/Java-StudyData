import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    /**
     *  因为对于User的操作
     *  肯定存在增删改查,或者其他的操作方式
     *  那么可以在给UserAction写出对应的方法
     *  返回值可以我们自己定义
     *  在struts.xml中的result标签中
     *  可以找到对应的结果就可以了
     * @return
     */
    public String insert(){
        System.out.println("Insert success!~");
        return "success";
    }
    public String delete(){
        System.out.println("Delete success!~");
        return "success";
    }
    public String update(){
        System.out.println("Update success!~");
        return "success";
    }
    public String query(){
        System.out.println("Query success!~");
        return "success";
    }

}
