package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.controller.CommandHandler;

//@Controller
public class ModifyHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";
	
	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modService = new ModifyArticleService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request,response);
		} else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request,response);
		}else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String noVal= request.getParameter("no");
			int no = Integer.valueOf(noVal);
			System.out.println(no);
			ArticleData articleData = readService.getArticle(no, false);
			User authUser = (User)request.getSession().getAttribute("authUser");
			if(!canModify(authUser, articleData)) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(authUser.getId(),no,articleData.getArticle().getTitle(),
					articleData.getContent().getContent());
			
			request.setAttribute("modReq", modReq);
			return FORM_VIEW;
					
		}catch(ArticleNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}

	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User  authUser = (User)request.getSession().getAttribute("authUser");
		String noVal =request.getParameter("no");
		int no = Integer.valueOf(noVal); 
		
		ModifyRequest modReq = new ModifyRequest(authUser.getId(),no, request.getParameter("title"),
				request.getParameter("content"));
		request.setAttribute("modReq", modReq);
		
		Map<String, Boolean> errors = new HashMap<>();
		
		request.setAttribute("errors", errors);
		modReq.validate(errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			modService.modify(modReq);
			return "/WEB-INF/view/modifySuccess.jsp";
		}catch(ArticleNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}

	


	
	
}
