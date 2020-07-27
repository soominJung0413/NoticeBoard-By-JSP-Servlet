package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	public static void close(AutoCloseable... resource) {//가변인자

		try {
			for(AutoCloseable res : resource) {
				res.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		if(con != null) {
			try {
				con.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
