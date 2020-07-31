<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@taglib prefix="ch" tagdir="/WEB-INF/tags" %>
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
<title>회원제 게시판 예제</title>
</head>
<body>
<div class="container">
<!-- 	<nav class="nav">
  	<a class="nav-link active" href="join.do">회원 가입</a>
  	<a class="nav-link" href="#">Link</a>
  	<a class="nav-link" href="#">Link</a>
  	<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	</nav> -->
	<ch:isLogin>
		<p class="font-italic">${authUser.id }님, 안녕하세요 :)</p>
		<hr />
		<nav class="nav">
		<a class="nav-link active" href="logout.do">로그아웃</a>
  		<a class="nav-link" href="changePwd.do">암호변경하기</a>
  		<a class="nav-link" href="${ctxPath}/article/write.do">작성하기</a>
  		<a class="nav-link" href="${ctxPath }/article/list.do">게시판 보기</a>
		</nav>
	</ch:isLogin>
	<ch:notLogin>
	<nav class="nav">
  	<a class="nav-link active" href="join.do">회원 가입</a>
  	<a class="nav-link" href="login.do">로그인</a>
  	
  	<div>
  		<img src="/images/MariaDB.jpg" alt="이미지 깨짐" />
  	</div>
	</nav>
	</ch:notLogin>
	</div>
</body>
</html>