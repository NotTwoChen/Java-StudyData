import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ToolsForVisitTimes {

    public static void getVisitTimes(HttpServletRequest request){
        ServletContext getServletContext = request.getServletContext();
        Object count = getServletContext.getAttribute("count");
        if (count == null){
            getServletContext.setAttribute("count",1L);
            System.out.println("这是第1次访问");
        }else {
            long l = (long) count;
            l++;
            System.out.println("这是第" + l + "次访问");
            getServletContext.setAttribute("count",l);
        }
    }
}
