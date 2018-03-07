package com.wsh.config;

import com.wsh.config.MyMvcConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 是Spring提供用来配置Servlet3.0+配置的接口
 * 实现该接口后,就可以将WebInitializer用来替代Web.xml配置文件
 * 会自动被SpringServletContainerInitializer获取到
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        // 将配置类与当前的ServletContext关联起来
        context.setServletContext(servletContext);
        context.refresh();

        // 注册SpringMVC的dispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));

        servlet.addMapping("/");

        // 最先加载
        servlet.setLoadOnStartup(1);


    }
}
