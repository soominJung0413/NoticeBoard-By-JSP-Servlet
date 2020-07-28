package test;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

@WebServlet("/test/update")
public class TestDaoUpdate extends HttpServlet{
	
	
	@Override//<<
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		try(Connection con = ConnectionProvider.getConnection()){
			memberDao.update(con, new Member("hong","홍삼식","123456",new Date()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//<<
	
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 super.doGet(req, resp);
	}
}
