package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Writer;
import article.service.WriteArticleService;
import auth.service.User;
import mvc.controller.CommandHandler;

//@Controller
public class WriteArticleHandler implements CommandHandler{
	
	private static final String FORM_VIEW ="/WEB-INF/view/newArticleForm.jsp";
	private WriteArticleService service = new WriteArticleService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Boolean> errors = new HashMap<>();
		
		request.setAttribute("errors", errors);
		
		User user = (User)request.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user,request);
		writeReq.Validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		
		int newArticleNo = service.write(writeReq);
		request.setAttribute("newArticleNo", newArticleNo);
		return "/WEB-INF/view/newArticleSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest request) {
		return new WriteRequest(new Writer(user.getId(),user.getName() ), request.getParameter("title") , 
				request.getParameter("content"));
	}
}
