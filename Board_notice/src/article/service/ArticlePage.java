package article.service;

import java.util.List;

import article.model.Article;

// Pagenation
public class ArticlePage {
	private int total;//총 레코드 수
	private int currentPage;//현재페이지
	private List<Article> content;
	private int totalPages;//총 페이지수
	private int startPage;// 1 2 3 4 5 의 1 즉 첫 페이지
	private int endPage;// 1 2 3 4 5 의 5 즉 마지막 페이지
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total == 0) { // 게시물이 없다면
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { // 게시물이 있다면
			totalPages = total / size; // 페이지 나누는 작업
			if(total % size >0) {// 떨어지지않으면 임의 페이지 생성
				totalPages++;
			}
			
			startPage = (currentPage -1 ) / 5* 5 +1;
			
			endPage = startPage + 4 ; 
			endPage = Math.min(endPage, totalPages);
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean hasNoArticles() {
		return total == 0 ;
	}
	
	public boolean hasArticles() {
		return total > 0 ;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<Article> getContent() {
		return content;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
}
