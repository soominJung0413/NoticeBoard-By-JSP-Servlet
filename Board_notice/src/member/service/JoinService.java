package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

//@Service
public class JoinService {
	
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Member member = memberDao.selectById(con, joinReq.getId());
			if(member != null) {
				JdbcUtil.rollback(con);
				throw new DuplicateMemberException();
			}
			
			memberDao.insert(con, new Member(joinReq.getId(), joinReq.getName(),
					joinReq.getPassword(),new Date())
					);
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(con);
		}
	}
}
