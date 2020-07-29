package article.model;

//Value Object
public class ArticleContent {
	private Integer number;
	private String content;
	
	public ArticleContent(Integer number, String content) {
		this.number = number;
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	public Integer getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "ArticleContent [number=" + number + ", content=" + content + "]";
	}
	
	
}
