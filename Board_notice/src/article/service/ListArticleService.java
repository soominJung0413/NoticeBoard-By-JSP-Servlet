package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

//@Service
public class ListArticleService {
	
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try(Connection con = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(con);
			List<Article> content = articleDao.select(con, (pageNum - 1) * size, size );
			return new ArticlePage(total, pageNum, size, content);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
