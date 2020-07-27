package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

//@Repository
public class MemberDao {
	
	public Member selectById(Connection con, String id) throws SQLException {
		ResultSet rs =null;
		final String sql = "SELECT * FROM member WHERE memberid = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member(
						rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate"))
						);
			}
			return member;
		}finally{
			JdbcUtil.close(rs);
		}
	}

	private Date toDate(Timestamp timestamp) {
		return timestamp == null ? null  : new Date(timestamp.getTime())  ;
	}
	
	public void insert(Connection con , Member mem) {
		final String sql = "INSERT INTO member VALUES (?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, mem.getMemberid());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegdate().getTime()));
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
