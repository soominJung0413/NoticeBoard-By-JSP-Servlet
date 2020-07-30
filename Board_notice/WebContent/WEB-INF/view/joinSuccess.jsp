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
<title>가입 완료</title>
</head>
<body>
	<div class="container">
	<div class="card" style="width: 18rem;">
  <img src="C:\Users\admin\Pictures\Saved Pictures\Hello.jpg" class="card-img-top" alt="이미지 깨짐...">
  <div class="card-body">
    <h5 class="card-title">회원 가입이 완료되었습니다. :)</h5>
    <p class="card-text">${param.name} 님의 계정은 ${param.id } 입니다.</p>
    <a href="${ctxPath }/login.do" class="btn btn-primary">로그인</a>
  </div>
</div>
</div>
</body>
</html>