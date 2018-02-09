import java.lang.reflect.Method;

public class Demo03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Method a = Class.forName(Demo02.class.getName()).getDeclaredMethod("a");
        MyAnnotation annotation = a.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.param1());
        System.out.println(annotation.param2());
    }
}
