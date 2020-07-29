package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;

//@Repository
public class ArticleDao {
	public Article insert(Connection con, Article article) throws SQLException {
		PreparedStatement pstmt =null;
		Statement stmt = null;
		ResultSet rs = null;
		final String sql ="INSERT INTO article (writer_id, writer_name, title, regdate, moddate, read_cnt) VALUES ( ?, ?, ?, ?, ?, 0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount =pstmt.executeUpdate();
			
			if(insertedCount > 0) {
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT last_insert_id() from article");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Article(newNum, article.getWriter(), article.getTitle(), article.getRegDate(), article.getModifiedDate(), 0);
				}
			}
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection con) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			final String sql = "SELECT COUNT(*) FROM article";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Article> select(Connection con , int startRow, int size) throws SQLException{
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			final String sql = "SELECT * FROM article ORDER BY article_no DESC LIMIT ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs  = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while(rs.next()) {
				result.add( convertArticle(rs) );
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(
					rs.getInt(1),
					new Writer(rs.getString(2), rs.getString(3)),
					rs.getString(4),
					toDate(rs.getTimestamp(5)),
					toDate(rs.getTimestamp(6)),
					rs.getInt(7)
				);
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
