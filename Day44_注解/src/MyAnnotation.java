import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Inherited
public @interface MyAnnotation {
    int param1() default 0;
    String param2() default "";
}
