package com.wsh.config;

import com.wsh.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 表示当前类是一个配置类
public class SpringConfig {


    /**
     * 通过@Bean指定下面方法返回值是一个Bean
     * @return
     */
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

}
