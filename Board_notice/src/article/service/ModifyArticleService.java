package article.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.servlet.http.Part;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

//@Service
public class ModifyArticleService {
	
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	private WriteFileService writeService = new WriteFileService();
		
	// 필요한 것은 번호에 따른 컨텐츠 테이블 로우 가져오기, fileName 비교후 다르면 delete write
	// 트랜젝션은 modify
	
		public void modify(ModifyRequest modReq, Part modFile) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Article article = articleDao.selectById(con, modReq.getArticleNumber());
			if( article == null) {
				throw new ArticleNotFoundException();
			}
			if(!canModify(modReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			
			ArticleContent articleContent = contentDao.selectById(con, modReq.getArticleNumber());
			if(!articleContent.getFileName().equals(modReq.getFileName())) {
				/// 파일 이름 변경 업데이트 문과 Part에서 파일 지우기 로직이 필요함.
				System.out.println("기존 파일 이름 : "+articleContent.getFileName());
				System.out.println("새로운 파일 이름 : "+modReq.getFileName());
				writeService.delete(articleContent.getFileName(), modReq.getArticleNumber());
				writeService.write(modFile, modReq.getArticleNumber());
				contentDao.updateAtFile(con, modReq.getArticleNumber(), modReq.getContent(), modReq.getFileName());
			} else {
				contentDao.update(con, modReq.getArticleNumber(), modReq.getContent());
			}
			
			articleDao.update(con, modReq.getArticleNumber(), modReq.getTitle());
//			contentDao.update(con, modReq.getArticleNumber(), modReq.getContent());
			con.commit();
		}catch(SQLException |  IOException e ) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		}catch(PermissionDeniedException e){
			JdbcUtil.rollback(con);
			throw e;
		}finally {
			JdbcUtil.close(con);
		}			
		}


		private boolean canModify(String userId, Article article) {
			return article.getWriter().getId().equals(userId);
		}
}
