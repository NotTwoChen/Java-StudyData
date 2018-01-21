import com.wsh.bean.Student;
import com.wsh.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        HibernateUtil hibernateUtil = new HibernateUtil();
        Student handle = hibernateUtil.handle(session -> session.get(Student.class, 1L));
        System.out.println(handle);
    }
}
