package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

//@Repository
public class ArticleContentDao {
	
	public ArticleContent insert(Connection con, ArticleContent content) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			final String sql ="INSERT INTO article_content (article_no, content) VALUES ( ?, ? )";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertCount = pstmt.executeUpdate();
			if(insertCount > 0) {
				return content;
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
}
