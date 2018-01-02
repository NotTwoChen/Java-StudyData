import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TargetServlet",urlPatterns = "/target")
public class TargetServlet extends HttpServlet {

    private int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        System.out.println(count);

        System.out.println("我是TargetServlet");
        // 获得域属性
        Object name = request.getAttribute("name");

        System.out.println(name);


        response.setContentType("text/html;charset=utf-8");

        response.setCharacterEncoding("utf-8");

        response.getWriter().write("我是TargetServlet");

    }
}
