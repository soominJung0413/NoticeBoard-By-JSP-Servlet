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
<title>가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<div class="form-group">
		<label for="userid">아이디</label>
		<input type="text" name="id" value="${param.id}" class="form-control form-control-sm" id="userid" aria-describedby="emailHelp"/>
		<c:if test="${errors.id}">
		<small id="useridHelp" class="form-text text-muted">ID를 입력하세요</small>
		</c:if>
		<c:if test="${errrors.duplicateId}">
		<small id="useridHelp" class="form-text text-muted">이미 사용 중인 아이디 입니다.</small>
		</c:if>
		</div>
		<div class="form-group">
		<label for="username">이름</label>
		<input type="text" name="name" value="${param.name}" class="form-control form-control-sm" id="username" aria-describedby="emailHelp"/>
		<c:if test="${errors.name}">
		<small id="usernameHelp" class="form-text text-muted">이름을 입력하세요.</small>
		</c:if>
		</div>
		<div class="form-group">
		<label for="userPassword">암호</label> 
		<input type="password" name="password" class="form-control form-control-sm" id="userPassword" aria-describedby="emailHelp"  />
		<c:if test="${errors.password}">
		<small id="userPasswordHelp" class="form-text text-muted">암호를 입력하세요.</small>
		</c:if>
		</div>
		<div class="form-group">
			<label for="userConfirmPassword">암호 확인</label> 
		<input type="password" name="confirmPassword" class="form-control form-control-sm" id="userConfirmPassword" aria-describedby="emailHelp"    />
		<c:if test="${errors.confirmPassword}">
		<small id="userConfirmPasswordHelp" class="form-text text-muted">확인을 입력하세요.</small>
		</c:if>
		<c:if test="${errors.notMatch}">
		<small id="userConfirmPasswordHelp" class="form-text text-muted">암호와 확인이 일치하지 않습니다.</small>
		</c:if>
		</div>
		<input type="submit" class="btn btn-primary" value="가입" />
	</form>
</body>
</html>