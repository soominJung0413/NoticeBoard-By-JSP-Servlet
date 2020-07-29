package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.command.WriteRequest;
import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

//@Service
public class WriteArticleService {

	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao articleContentDao = new ArticleContentDao();
	
	public Integer write(WriteRequest req) {
		Connection con = null;
		try{
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Article article = toArticle(req);
			Article savedArticle = articleDao.insert(con, article);
			if(savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			ArticleContent content = new ArticleContent(savedArticle.getNumber(),
					req.getContent());
			ArticleContent savedContent = articleContentDao.insert(con, content);
			if(savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}
			
			con.commit();
			
			return savedArticle.getNumber();
		}catch(SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException();
		}catch(RuntimeException e1) {
			JdbcUtil.rollback(con);
			throw e1;
		}finally {
			JdbcUtil.close(con);
		}
	}

	private Article toArticle(WriteRequest req){
		Date now = new Date();
		return new Article(null, req.getWriter(),req.getTitle(),now,now,0);
	}
}
