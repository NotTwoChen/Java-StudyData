package com.wsh.config;

import com.wsh.converter.MyMessageConverter;
import com.wsh.interceptor.ShowInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@EnableScheduling // 开启对异步执行的支持
@ComponentScan("com.wsh")
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * @return InternalResourceViewResolver 是SpringMVC视图渲染的核心机制
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // jsp页面前缀
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        // 后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyMessageConverter myMessageConverter(){
        return new MyMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myMessageConverter());
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler指的是对外暴露的访问路径
        // addResourceLocations指的是文件放置的目录
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public ShowInterceptor showInterceptor(){
        return new ShowInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(showInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 路径为/index的请求,显示名称为index的视图
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 不做匹配,则不会忽略.后面的内容
        configurer.setUseSuffixPatternMatch(false);
    }
}
