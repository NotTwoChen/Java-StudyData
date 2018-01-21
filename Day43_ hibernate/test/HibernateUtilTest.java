import com.wsh.bean.Student;
import com.wsh.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

    @Test
    public void show(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Student handle = hibernateUtil.handle(session -> session.get(Student.class, 1L));
        System.out.println(handle);
        hibernateUtil.handle(new HibernateUtil.ResultHandle<Object>() {
            @Override
            public Object resultHandle(Session session) {
                return null;
            }
        });
    }

}