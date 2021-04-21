package com.bit.mysite.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoadListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext context = sce.getServletContext();
		String contextConfigLoacation = context.getInitParameter("contextConfigLoacation");
        System.out.println("Application Starts..." + contextConfigLoacation);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
	
}
