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
<title>게시글 삭제</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>${delReq.articleData.article.number}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${delReq.articleData.article.writer.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${delReq.articleData.article.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td style="white-space: pre-wrap;"><c:out value="${delReq.articleData.content.content}" /></td>
		</tr>
	</table>
	<hr />
	
	게시글 삭제.
	<form action="delete.do?no=${delReq.articleData.article.number}" method="post">
		비밀번호 : <input type="text" name="password"  /> 
		<c:if test="${errors.password }">비밀번호를 입력해주세요.</c:if>
		<c:if test="${errors.notMatchPassword}">비밀번호가 알맞지 않습니다.</c:if>
		<br />
		비밀번호 확인 : <input type="password" name="confirmPassword"  /> 
		<c:if test="${errors.confirmPassword }">확인비밀번호를 입력해주세요</c:if>
		<c:if test="${errors.notMathConfirmPassword}">확인비밀번호는 비밀번호와 동일해야합니다.</c:if>
		<br />
		
		<input type="submit" value="삭제" />
	</form>
</body>
</html>