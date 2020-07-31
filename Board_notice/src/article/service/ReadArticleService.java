package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.connection.ConnectionProvider;

//@Service
public class ReadArticleService {
	private  ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao articleContentDao  = new ArticleContentDao();
	
	public ArticleData getArticle (int articleNum, boolean increaseReadCount) {
		try(Connection con = ConnectionProvider.getConnection()){
			Article article = articleDao.selectById(con, articleNum);
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			ArticleContent content = articleContentDao.selectById(con, articleNum);
			//여기서 넘버 추출. 파일 이름도 추출
			if(content == null) {
				throw new ArticleContentNotFoundException();
			}
			if(increaseReadCount) {
				articleDao.increaseReadCount(con, articleNum);
			}
			return new ArticleData(article,content);
		}catch(SQLException e) {
			throw new RuntimeException(e);
			}
	}
}
