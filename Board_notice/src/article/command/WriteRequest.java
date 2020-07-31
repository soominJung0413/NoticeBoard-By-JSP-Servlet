package article.command;

import java.util.Map;

import article.model.Writer;

//Command Object
public class WriteRequest {
  private Writer writer;
  private String title;
  private String content;
  private String fileName;
  
public WriteRequest(Writer writer, String title, String content,  String fileName) {
	this.writer = writer;
	this.title = title;
	this.content = content;
	this.fileName = fileName;
}

public WriteRequest(Writer writer, String title, String content) {
	this(writer,title,content,"");
}

public String getFileName() {
	return fileName;
}
  
  public Writer getWriter() {
	return writer;
}
  public String getTitle() {
	return title;
}
  public String getContent() {
	return content;
}
  
  public void Validate(Map<String, Boolean> errors) {
	  if(title == null || title.trim().isEmpty()) {
		  errors.put("title", Boolean.TRUE);
	  }
  }

@Override
public String toString() {
	return "WriteRequest [writer=" + writer + ", title=" + title + ", content=" + content + "]";
}
  
  
  
}
