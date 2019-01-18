package com.pluralsight;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {


    // In this class we initialize the Dispatcher Servlet
// This Dispatcher Servlet is also has the mapping to *.html pages (i.e any requst ending with html )
// Now this Dispatcher Servlet goes and checks for controller  i.e it checks if there is any class that has @Controller tags
// So with out Dispatcher Servlet initialized we can't use the Controller classes.
// In other words Dispatcher servlet's work is to identity the @Controller Classes.
// So when ever a request is sent with *.html (html at the end) format it goes to Dispatcher Servlet
// Then this servlet checks for any Controller is present to handle this request.
// By the way we also identify the Configuration class in this
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.html");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.pluralsight.WebConfig");
        return context;
    }
}
