package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.controller.CommandHandler;

//@Controller
public class ListArticleHandler implements CommandHandler{
	
	private ListArticleService service = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String  pageNoVal = request.getParameter("pageNo"); // 현재 페이지 넘버
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.valueOf(pageNoVal);
		}
		ArticlePage articlePage = service.getArticlePage(pageNo);
		request.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/listArticle.jsp";
	}
}
