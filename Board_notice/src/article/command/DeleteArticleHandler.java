package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.DeleteRequest;
import article.service.DeleteService;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.controller.CommandHandler;

//@Controller
public class DeleteArticleHandler  implements CommandHandler{
	private ReadArticleService readService = new ReadArticleService();
	private DeleteService deleteService = new DeleteService();
	
	private static final String FORM_VIEW ="/WEB-INF/view/deleteForm.jsp";
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			return processDelete(request, response);
		}else {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processDelete(HttpServletRequest request, HttpServletResponse response) {
		//Request객체 생성
		String noVal = request.getParameter("no");
		int no = Integer.valueOf(noVal);
		
		ArticleData articleData = readService.getArticle(no, false);
		User authUser = (User)request.getSession().getAttribute("authUser");
		
		DeleteRequest delReq = new DeleteRequest(no, authUser.getId(), articleData);
		delReq.setPassword(request.getParameter("password"));
		delReq.setConfirmPassword(request.getParameter("confirmPassword"));
		//폼검증
		Map<String, Boolean> errors = delReq.validate(new HashMap<>());		
		request.setAttribute("errors", errors);
		request.setAttribute("delReq", delReq);
		delReq.validate(errors);
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}	
		//비밀번호 확인
		if(!authUser.getPassword().equals(delReq.getPassword())) {
			errors.put("notMatchPassword",Boolean.TRUE);	
			return FORM_VIEW;
		}
		if(!delReq.passwordEqualConfirmPassword()) {
			errors.put("notMathConfirmPassword",Boolean.TRUE);
			return FORM_VIEW;
		}
		//서비스 수행 해당글 지워주면 됨!
		deleteService.deleteService(delReq.getArticleNumber());
		// 종료.		
		return "/WEB-INF/view/deleteSuccess.jsp";
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String noVal = request.getParameter("no");
		int no = Integer.valueOf(noVal);//게시글 번호 가져옴
		
		ArticleData articleData = readService.getArticle(no, false);
		User authUser = (User)request.getSession().getAttribute("authUser");
		if(!canDelete(authUser, articleData)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		DeleteRequest delReq= new DeleteRequest(no, authUser.getId(), articleData);
		request.setAttribute("delReq", delReq);
		return FORM_VIEW;
	}
	
	private boolean canDelete(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
}
