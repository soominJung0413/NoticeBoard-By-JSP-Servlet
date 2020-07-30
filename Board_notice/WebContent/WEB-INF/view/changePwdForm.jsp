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
<title>비밀번호 변경 폼</title>
</head>
<body>
	<form action="changePwd.do" method="post">
	<label for="currentPassword">현재암호</label>
<input type="password" name="curPwd" id="currentPassword" class="form-control form-control-sm" aria-describedby="passwordHelpBlock">
<c:if test="${errors.curPwd}">
<small id="passwordHelpBlock" class="form-text text-muted">
 현재 암호를 입력하세요.
</small>
</c:if>
<c:if test="${errors.badCurPwd}">
<small id="passwordHelpBlock" class="form-text text-muted">
 현재 암호가 일치하지 않습니다.
</small>
</c:if>

<label for="newPassword">새 암호</label>
<input type="password" id="newPassword" name="newPwd" class="form-control form-control-sm" aria-describedby="passwordHelpBlock">
<c:if test="${errors.newPwd}">
<small id="passwordHelpBlock" class="form-text text-muted">
  새 암호를 입력하세요.
</small>
</c:if>
	<label>
		<input type="submit" class="btn btn-primary"  value="암호 변경" />
	</label>
	</form>
</body>
</html>