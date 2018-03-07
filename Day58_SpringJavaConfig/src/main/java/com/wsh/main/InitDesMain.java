package com.wsh.main;

import com.wsh.config.InitDesConfig;
import com.wsh.service.BeanService;
import com.wsh.service.JSR250Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDesMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitDesConfig.class);
        JSR250Service jsr250Service = context.getBean(JSR250Service.class);
        BeanService beanService = context.getBean(BeanService.class);

        /** Bean 的初始化和销毁
         *
         * 有时需要在Bean使用之前或之后做些必要的操作,Spring对Bean的声明周期的操作提供了支持
         *
         *      Java配置方式:使用@Bead的initMethod和destroyMethod.
         *      注解方式:利用JSR250的@PostConstruct和@PreDestroy
         */
    }
}
