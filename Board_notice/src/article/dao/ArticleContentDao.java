package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

//@Repository
public class ArticleContentDao {
	
	public int update (Connection con, int no, String content) throws SQLException {
		final String sql ="UPDATE article_content SET content =? WHERE article_no = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
	
	public ArticleContent selectById(Connection con, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String sql = "SELECT * FROM article_content WHERE article_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleContent content = null;
			if(rs.next()) {
				content = new ArticleContent(rs.getInt(1), rs.getString(2));
			}
			return content;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
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
