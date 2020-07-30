package article.service;

import java.util.Map;

import article.model.Article;

//Command Object
public class DeleteRequest {
	private int articleNumber;
	private String userId;
	private ArticleData articleData;	
	private String password;
	private String confirmPassword;
	
	public DeleteRequest(int articleNumber, String userId,  ArticleData articleData) {
		this.articleNumber = articleNumber;
		this.userId = userId;
		this.articleData = articleData;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Map<String, Boolean> validate(Map<String, Boolean> errors){
		if(password == null || password.trim().isEmpty()) {
			errors.put("password",Boolean.TRUE);
		}
		if(confirmPassword == null || confirmPassword.trim().isEmpty()) {
			errors.put("confirmPassword",Boolean.TRUE);
		}
		return errors;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getPassword() {
		return password;
	}
	
	public boolean passwordEqualConfirmPassword() {
		return this.password.equals(confirmPassword);
	}
	

	public int getArticleNumber() {
		return articleNumber;
	}



	public String getUserId() {
		return userId;
	}



	public ArticleData getArticleData() {
		return articleData;
	}







}
