package article.model;

//Value Object
public class ArticleContent {
	private Integer number;
	private String content;
	private String fileName;
	
	public ArticleContent(Integer number, String content) {
		this(number,content,"");
	}
	
	public ArticleContent(Integer number, String content,String fileName) {
		this.number = number;
		this.content = content;
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public String getContent() {
		return content;
	}
	public Integer getNumber() {
		return number;
	}

	
	
}
