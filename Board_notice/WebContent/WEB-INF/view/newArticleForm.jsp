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
<title>게시글 쓰기</title>
</head>
<body>
	<form action="write.do" method="post">
		<p>
		 제목 :<br /> <input type="text" name="title" value="${param.title}" />
		 <c:if test="${errors.title}">제목을 입력하세요.</c:if>
		</p>
		<p>
		 내용: <br /> <textarea name="content"  cols="30" rows="5" >${param.content}</textarea>
		</p>
		<input type="submit" value="새 글 등록" />
	</form>
</body>
</html>