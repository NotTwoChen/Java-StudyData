import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IncludeServlet",urlPatterns = "/include")
public class IncludeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是IncludeServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/target");

        response.setCharacterEncoding("utf-8");

        requestDispatcher.include(request,response);

        System.out.println("IncludeServlet请求转发TargetServlet已经完成");

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println("我是IncludeServlet");

    }
}
