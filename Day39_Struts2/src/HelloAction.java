import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    public String hello(){

        return "success";
    }

    /**
     * 如果在struts.xml配置文件中
     * 并未指定action的method属性的值
     * 那么action会默认调用该类的execute方法
     * execute(执行)
     * 即其父类ActionSupport的方法
     * 并且会默认返回值"success"
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
