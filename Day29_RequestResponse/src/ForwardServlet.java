import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForwardServlet",urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是ForwardServlet");
        // 执行请求转发到TargetServlet

        // 设置一个域属性
        request.setAttribute("name","张三");

        // 获得请求分发者
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/target");
        // forward方法,就表示请求转发
        requestDispatcher.forward(request,response);// 转发

        System.out.println("ForwardServlet请求转发TargetServlet已经完成");

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().write("我是ForwardServlet");

//        requestDispatcher.include(request,response);// 包含
    }
}
