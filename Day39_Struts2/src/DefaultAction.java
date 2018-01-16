import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("执行了默认类以及默认执行方法!~");
        return super.execute();
    }
}
