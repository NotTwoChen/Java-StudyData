package com.wsh.anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 标注在类的声明上
@Retention(RetentionPolicy.RUNTIME) // 保存在生成的字节码文件中
@Documented // 将注解的信息包含在javadoc生成的文档中
@Configuration
@ComponentScan
public @interface MyConfiguration {

    /**
     * 传入的value参数,会覆盖元注解@ComponentScan注解的value上
     * @return
     */
    String[] value() default{};

}
