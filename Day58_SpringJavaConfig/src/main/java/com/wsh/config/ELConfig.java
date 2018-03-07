package com.wsh.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;


@Configuration
@ComponentScan("com.wsh")
@PropertySource("classpath:com/wsh/properties/show.properties") // 指定资源文件的路径
public class ELConfig {

    // 1.注入普通字符串
    @Value("注入普通字符串")
    private String normal;

    // 2.注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    // 3.注入表达式的结果,调用Math类静态方法 * 100.0 得到的结果
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    // 4.注入其他Bean的属性
    @Value("#{aopDemoService.name}")
    private String fromAnother;

    // 5.注入文件资源
    @Value("classpath:com/wsh/properties/show.txt")
    private Resource showFile;

    // 6.注入网站资源
    @Value("http://www.baidu.com")
    private Resource baiduUrl;

    // 7.注入资源文件(.properties)中的内容
    // 已经通过propertySource指定了资源文件的路径
    @Value("${name}")
    private String name;

    // 7.若要使用value注入,则需要搭配如下静态方法
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    // 7.注入资源文件后,也可以在environment对象中获得资源文件中的内容
    @Autowired
    private Environment environment;

    public void outputResource(){
        try {
            System.out.println("normal:---" + normal);
            System.out.println("osName:---" + osName);
            System.out.println("randomNumber:---" + randomNumber);
            System.out.println("fromAnother:---" + fromAnother);

            System.out.println(IOUtils.toString(showFile.getInputStream()));
            System.out.println(IOUtils.toString(baiduUrl.getInputStream()));
            System.out.println("name:---" + name);
            System.out.println("environment.getProperty('author'):---" + environment.getProperty("author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
