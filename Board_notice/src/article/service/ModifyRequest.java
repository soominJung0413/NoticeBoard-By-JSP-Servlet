package article.service;

import java.util.Map;

import article.model.ArticleContent;

//Command Object
public class ModifyRequest {
	
	private String userId;
	private int articleNumber;
	private String title;
	private String content;
	private ArticleData articleData;
	private String fileName;
	
	public ModifyRequest(String userId, int articleNumber, String title, String content, String fileName) {
			this.userId=userId;
			this.articleNumber=articleNumber;
			this.title=title;
			this.content = content;
			this.fileName = fileName;
	}
	
	public ModifyRequest(String userId, int articleNumber, String title, String content, ArticleData articleData) {
		this.userId = userId;
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
		this.articleData = articleData;
	}
	public String getFileName() {
		return fileName;
	}
	
	public ArticleData getArticleData() {
		return articleData; 
	}
	
	public int getArticleNumber() {
		return articleNumber;
	}
	public String getContent() {
		return content;
	}
	public String getTitle() {
		return title;
	}
	public String getUserId() {
		return userId;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if ( title == null || title.trim().isEmpty()) {
			errors.put("title",Boolean.TRUE);
		}
	}
}
