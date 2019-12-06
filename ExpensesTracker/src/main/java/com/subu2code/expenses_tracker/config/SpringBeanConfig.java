package com.subu2code.expenses_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * This is the Spring Configuration class
 * In this, I mentioned the scan package for components as com.subu2code.expenses_tracker
 * And add my View resolver   
 * 
 * */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.subu2code.expenses_tracker")
public class SpringBeanConfig {

	@Bean
	public ViewResolver getViewResolver() {
		
		System.out.println("ViewResolver Bean was created");
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
