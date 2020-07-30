package article.service;

import java.util.Map;

//Command Object
public class ModifyRequest {
	
	private String userId;
	private int articleNumber;
	private String title;
	private String content;
	
	public ModifyRequest(String userId, int articleNumber, String title, String content) {
		this.userId = userId;
		this.articleNumber = articleNumber;
		this.title = title;
		this.content = content;
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
