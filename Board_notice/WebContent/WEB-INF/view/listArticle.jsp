<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>게시글 목록</title>
</head>
<body>

	<div class="container">
	<table border="1" width="100%">
		<tr>
			<td colspan="4"> <a href="write.do">[게시글 쓰기]</a> </td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:if test="${articlePage.hasNoArticles()}">
			<tr>
				<td colspan="4">게시글이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="article" items="${articlePage.content}">
			<tr>
				<td>${article.number}</td>
				<td>
					<a href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}">
						<c:out value="${article.title}" />
					</a>
				</td>
				<td>${article.writer.name}</td>
				<td>${article.readCount}</td>
			</tr>
		</c:forEach>
		
		<c:if test="${articlePage.hasArticles() }">
			<tr>
				<td colspan="4">
					<c:if test="${articlePage.startPage > 5}">
						<a href="list.do?pageNo=${articlePage.startPage -5}">[이전]</a>
					</c:if>
					<c:forEach var="pNo" begin="${articlePage.startPage}" end="${articlePage.endPage}">
						<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
					</c:forEach>
					<c:if test="${articlePage.endPage < articlePage.totalPages}">
						<a href="list.do?pageNo=${articlePage.startPage+5}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:if>
	</table>
	</div>
</body>
</html>