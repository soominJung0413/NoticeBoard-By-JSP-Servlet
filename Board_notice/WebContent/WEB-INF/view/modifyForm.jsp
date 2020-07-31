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
<title>게시글 수정</title>
</head>
<body>
	<form action="modify.do?no=${modReq.articleNumber}" method="post" enctype="multipart/form-data">
	<!-- 폴더 파일을 지우고 새 파일로 업로드 시켜야함, delete 와 update 트랜젝션, 파일 갱신과 삭제가 일어나야함. -->
		<!-- 파일 이름이 데이터베이스 이름과 같다면 그대로, 같지않다면 삭제 후 저장. -->
		<div class="form-group">
			<label for="articleNum">번호</label> 
			 <label  >${modReq.articleNumber}</label>
		</div>
		<div class="form-group">
		 	<label for="article_Title">제목</label>
			<input type="text" id="article_Title" class="form-control form-control-sm" name="title" value="${modReq.title}" /> 
			<!-- modReq 객체에 파일 명을 추가해야할 듯 함. -->
			<c:if test="${not empty errors}">
			<small id="articleTitleHelp" class="form-text text-muted">제목을 입력하세요.</small>
			</c:if>
		</div>
		<div class="form-group">
		<c:if test="${not empty modReq.articleData.content.fileName}">
		<label> 게시한 이미지 </label>
				<img width="40%" src="/images/${modReq.articleData.content.number}/${modReq.articleData.content.fileName}" alt="이미지 깨짐" />
		</c:if>
		<br />
			<label for="article_content">내용</label>
			<textarea class="form-control" rows="5" cols="30" name="content">${modReq.content}</textarea>
		</div>
		<input type="file" name="modFile" accept="images/*" /><br />
		<input type="submit" class="btn btn-primary" value="수정" />
	</form>
</body>
</html>