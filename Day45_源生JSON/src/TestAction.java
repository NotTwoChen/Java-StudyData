import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestAction extends ActionSupport{

    public String test() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();

        String name = "{'name':'张三'}";

        JSONObject jsonObject = JSONObject.fromObject(name);

        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();

        writer.write(jsonObject.toString());

        writer.close();

        return SUCCESS;
    }
}
