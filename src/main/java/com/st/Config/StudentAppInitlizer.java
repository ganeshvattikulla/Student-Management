package com.st.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configFiles = { studentAppConfig.class };
		return configFiles;
	}

	@Override
	protected String[] getServletMappings() {
		String[] servletMappings = { "/" };
		return servletMappings;
	}

}
