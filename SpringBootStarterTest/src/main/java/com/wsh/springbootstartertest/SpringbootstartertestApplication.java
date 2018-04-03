package com.wsh.springbootstartertest;

import com.wsh.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@RestController
@ComponentScan("com.wsh")
public class SpringbootstartertestApplication {

	@Autowired
	DemoService demoService;

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views");
		viewResolver.setSuffix(".jsp");

		// 使用JstlView定义了一个InternalResourceViewResolver
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@RequestMapping("/")
	public String index(){
		return demoService.say();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstartertestApplication.class, args);
	}
}
