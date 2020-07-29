package test.article;

import java.io.IOException;
import java.sql.Connection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.dao.ArticleContentDao;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

@WebServlet("/test/articleContentDao")
public class ArticleContentDaoTestSerlvet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArticleContentDao dao = new ArticleContentDao();
		
		ArticleContent content = new ArticleContent(1, "content1");
		
		try(Connection con = ConnectionProvider.getConnection();){
			ArticleContent content2 = dao.insert(con, content);
			
			resp.getWriter().println(content2.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
