package com.wsh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnClass(DemoService.class)
@ConditionalOnProperty(prefix="hello",value="enabled",matchIfMissing=true)
public class DemoServiceAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Bean
    public DemoService demoService(){
        DemoService demoService = new DemoService();
        demoService.setMsg(demoProperties.getMsg());
        return demoService;
    }
}
