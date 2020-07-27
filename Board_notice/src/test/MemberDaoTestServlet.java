package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

@WebServlet("/test")
public class MemberDaoTestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			memberDao.insert(con, new Member(
					"hong"+new Random().nextInt(100),
					"홍길동",
					"123456",
					new Date())
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	
}
