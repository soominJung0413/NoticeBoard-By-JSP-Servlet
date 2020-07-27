package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String,CommandHandler> map = new HashMap<>();
       
	@Override
	public void init() throws ServletException {

		String filePath = getInitParameter("configFile");
//		System.out.println("\n파일경로: "+filePath);
		String realPath = getServletContext().getRealPath(filePath);
		
		try (FileInputStream fis = new FileInputStream(realPath);){			
			Properties prop = new Properties();
			prop.load(fis);
			Enumeration<String> keys = (Enumeration<String>)prop.propertyNames();
			
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
//				System.out.println("키 : " +key);
				String className = prop.getProperty(key);
//				System.out.println("클래스이름 : "+className);
				
				Class<CommandHandler> clazz = (Class<CommandHandler>) Class.forName(className);
				
				CommandHandler com = clazz.newInstance();
//				System.out.println(com);
				
				map.put(key,com);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

    public ControllerUsingURI() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}


	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 경로로 왔는지 파악, a.do b.do c.do
		String requestUri = request.getRequestURI();
		
		//localhost:8090/contextRoot/some/a.do
		String contextPath = request.getContextPath();
		int startIndex = requestUri.indexOf(contextPath);
		
		String uri = requestUri.substring(startIndex+contextPath.length(),requestUri.length());
		
//		System.out.println(uri);
		
		CommandHandler com = map.get(uri);
		String view ="";
		try {
			view = com.process(request, response);		
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		if(view != null) {
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	
	
}
