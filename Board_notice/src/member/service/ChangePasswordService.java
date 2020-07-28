package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

//@Service
public class ChangePasswordService {

	private MemberDao memberDao = new MemberDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection con = null;
		try{
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Member member = memberDao.selectById(con, userId);
			if(member == null) {
				throw new MemberNotFountException();
			}
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			member.changePassword(newPwd);
			memberDao.update(con, member);
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(con);
			throw new RuntimeException();
		}
	}
}
