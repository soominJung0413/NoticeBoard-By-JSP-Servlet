package test.article;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.dao.ArticleDao;
import article.model.Article;
import article.model.Writer;
import jdbc.connection.ConnectionProvider;


@WebServlet("/ArticleTestServlet")
public class ArticleDaoTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ArticleDaoTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao dao = new ArticleDao();
		
		Connection con;
		try {
			con = ConnectionProvider.getConnection();
		
		Writer writer = new Writer("hong","홍삼식");
		
		
		Article article = new Article(null, writer, "title1", new Date(), new Date(), 0);
		
		Article ar = dao.insert(con, article);
		
		response.getWriter().append("insert 한 정보 : "+ar.toString());
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
