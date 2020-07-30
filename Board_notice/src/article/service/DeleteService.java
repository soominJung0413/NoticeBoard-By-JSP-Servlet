package article.service;

import java.sql.Connection;

import article.dao.ArticleDao;
import jdbc.connection.ConnectionProvider;

//@Service
public class DeleteService {
	private ArticleDao articleDao = new ArticleDao();
	
	public void deleteService(int no) {
		
		try(Connection con = ConnectionProvider.getConnection()){
			con.setAutoCommit(false);
			articleDao.delete(con, no);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
