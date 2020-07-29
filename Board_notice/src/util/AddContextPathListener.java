package util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AddContextPathListener implements ServletContextListener {


    public AddContextPathListener() {
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	ServletContext application = sce.getServletContext();
    	String contextPath = application.getContextPath();
    	
    	application.setAttribute("ctxPath", contextPath);
    }
	
}
