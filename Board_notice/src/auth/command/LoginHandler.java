package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.controller.CommandHandler;

//@Controller
public class LoginHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/LoginForm.jsp";
	private LoginService loginService = new LoginService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = trim(request.getParameter("id"));
		String password = trim(request.getParameter("password"));
		
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		if(id==null ||id.isEmpty()) {
			errors.put("id",Boolean.TRUE);
		}
		if(password == null || password.isEmpty()) {
			errors.put("password",Boolean.TRUE);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			User user = loginService.login(id, password);
			request.getSession().setAttribute("authUser", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return null;
		}catch(LoginFailException e) {
			errors.put("idOrPwNotMatch",Boolean.TRUE);
			return FORM_VIEW;
		}
	
	}

	private String trim(String parameter) {
		return parameter == null ? null : parameter.trim() ;
	}
}
