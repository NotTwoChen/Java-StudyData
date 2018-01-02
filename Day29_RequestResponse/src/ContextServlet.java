import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ContextServlet",urlPatterns = "/context")
public class ContextServlet extends HttpServlet {
    private int a = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        a++;
        getServletContext().setAttribute("count",a);
        Object count = getServletContext().getAttribute("count");
        System.out.println(count);
    }
}
