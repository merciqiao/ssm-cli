package com.yingu.project.rest.app;

import com.yingu.project.rest.config.RequestLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableEurekaClient
@ComponentScan(value = {
		"com.yingu.project"
          })
@MapperScan("com.yingu.project.persistence.mysql.mapper")
@EnableNeo4jRepositories("com.yingu.project.persistence.neo4j.repository")
@EntityScan(basePackages = "com.yingu.project.persistence.neo4j.entity")
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	// 增加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestLog());
	}
}
