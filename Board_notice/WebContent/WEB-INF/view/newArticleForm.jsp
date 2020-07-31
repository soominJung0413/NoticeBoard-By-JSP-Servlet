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
	<form action="write.do" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">제목</label>
		 <input type="text" name="title" value="${param.title}" class="form-control form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp"/>
		 <c:if test="${errors.title}">
		 <small id="emailHelp" class="form-text text-muted">제목을 입력하세요</small>
		 </c:if>
		<br />
		<div class="form-group">
		<label for="content">내용</label>
		  <textarea class="form-control" id="content" rows="3" name="content">${param.content}</textarea>
		</div>
		<p>
		파일: <br />
		<input type="file" name="file1" accept="image/*" />
		</p>
		<input type="submit" class="btn btn-info" value="새 글 등록 :)" />
	</div>
	</form>
</body>
</html>