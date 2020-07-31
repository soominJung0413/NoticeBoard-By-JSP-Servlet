package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.dao.ArticleDao;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.controller.CommandHandler;

//@Controller
public class ReadArticleHandler implements CommandHandler{
	
	private ReadArticleService service = new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String noVal = request.getParameter("no");
		int articleNum =Integer.valueOf(noVal);
		try {
			//이 안에 다들어 있음.
			ArticleData data = service.getArticle(articleNum, true);
			request.setAttribute("articleData", data);
			return "/WEB-INF/view/readArticle.jsp";
		}catch(ArticleNotFoundException e) {
			request.getServletContext().log("no article",e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
