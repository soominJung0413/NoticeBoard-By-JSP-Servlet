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
<title>로그인</title>
</head>
<body>
	<form action="login.do" method="post">
		
			 <div class="form-group">
    	<label for="exampleInputEmail1">아이디</label>
    	<input type="text" name="id" value="${param.id}" class="form-control form-control-sm" id="exampleInputEmail1" aria-describedby="emailHelp">
    	<c:if test="${errors.id}">
    	<small id="emailHelp" class="form-text text-muted">ID를 입력하세요</small>
    	</c:if>
  		</div>			
		<div class="form-group">
    	<label for="exampleInputPassword1" >암호</label>
    	<input type="password" name="password" class="form-control form-control-sm" id="exampleInputPassword1">
    	<c:if test="${errors.password}">
    	<small id="emailHelp" class="form-text text-muted">암호를 입력하세요</small>
    	</c:if>
    	
  		</div>
		<input type="submit" class="btn btn-primary" value="로그인" />
		
		<c:if test="${errors.idOrPwNotMatch}">
		<small id="emailHelp" class="form-text text-muted">아이디와 암호가 일치하지 않습니다.</small>
		</c:if>
	</form>
</body>
</html>