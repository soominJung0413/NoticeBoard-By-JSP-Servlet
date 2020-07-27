package test;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;

@WebServlet("/test/insert")
public class MemberDaoSelectTestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		Connection con =null;
		
		try{
			con= ConnectionProvider.getConnection();
			
			System.out.println(memberDao.selectById(con, "hong39").toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
}
