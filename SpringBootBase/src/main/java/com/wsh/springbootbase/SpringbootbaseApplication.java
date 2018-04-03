package com.wsh.springbootbase;

import com.wsh.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 	核心注解:是一个组合注解,功能:配置,自动配置,扫描
 * 	自动配置:根据类路径中的jar包为当前项目自动配置
 * 	如果添加了spring-boot-starter-web依赖:(自动配置Tomcat和SpringMVC)
 * 	SpringBoot会自动扫描@SpringBootApplication所在类的同级包以及下级包里的BEan
 * 	下面是关闭:DataSource的自动配置
 * 	@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 *
 * 	@InportResource({"classpath:xxx.xml","classpath:xxx.xml",})
 */

@RestController
@SpringBootApplication
public class SpringbootbaseApplication {

	@Value("${project.author}")
	private String projectAuthor;

	@Value("${project.name}")
	private String projectName;

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/test1")
	public String index(){
		return "projectAuthor:---" + projectAuthor +
				"\nprojectName:---" + projectName;
	}

	@RequestMapping("/test2")
	public String index2(){
		return "author name is " + authorSettings.getName() +
				"\n\n  author gender is " + authorSettings.getGender();
	}


	public static void main(String[] args) {
		// 启动SpringBoot项目
		SpringApplication.run(SpringbootbaseApplication.class, args);
		// 关闭Banner

//		SpringApplication application = new SpringApplication(SpringbootbaseApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
	}
}
