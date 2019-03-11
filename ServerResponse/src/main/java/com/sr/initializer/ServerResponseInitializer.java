package com.sr.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.servlet.ServletContainer;

public class ServerResponseInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		ServletContainer servletContainer = null;

		servletContainer = new ServletContainer();
		System.out.println("Initializing....");
		ServletRegistration.Dynamic config = ctx.addServlet("jersey", servletContainer);
		config.setInitParameter("jersey.config.server.provider.packages", "com.sr.resource");
		config.addMapping("/api/*");
	}

}
