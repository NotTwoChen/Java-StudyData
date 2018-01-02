import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "ConfigServlet",urlPatterns = "/config")
public class ConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得web.xml中配置的局部参数或者注释中配置的局部参数
        String username = getServletConfig().getInitParameter("username");
        String gender = getServletConfig().getInitParameter("gender");
        System.out.println(username+"----"+gender);
    }
}
