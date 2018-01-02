import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "PicServlet",urlPatterns = "/pic")
public class PicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream fis = request.getServletContext().getResourceAsStream("img/img.jpg");
//        FileInputStream fis = new FileInputStream("../web/img/img.jpg");
        byte[] pics = new byte[1024*1024*10];
        int read = fis.read(pics);
        fis.close();
        response.getOutputStream().write(pics,0,read);
    }
}
