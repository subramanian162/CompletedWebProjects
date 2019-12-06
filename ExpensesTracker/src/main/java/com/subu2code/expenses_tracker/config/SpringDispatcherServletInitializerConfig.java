package com.subu2code.expenses_tracker.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * This is the Spring Dispatcher Servlet Initializer Class
 * In this class, I mentioned the requesting URL in order to handle.
 * And I also mentioned my Spring Configuration class.
 * 
 * */

public class SpringDispatcherServletInitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringBeanConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
