package com.wsh.config;

import com.wsh.service.TargetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TargetService devTargetService(){
        // 开发环境
        return new TargetService("for development profile");
    }

    @Bean
    @Profile("prod")
    public TargetService prodTargetService(){
        // 生产环境
        return new TargetService("for production profile");
    }
}
