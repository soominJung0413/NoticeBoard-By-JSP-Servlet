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
		<p>
		아이디 : <br /> <input type="text" name="id" value="${param.id}" />
		<c:if test="${errors.id}">ID를 입력하세요</c:if>
		<c:if test="${errrors.duplicateId}">이미 사용중인 아이디 입니다.</c:if>
		</p>
		<p>
		이름: <br /> <input type="text" name="name" value="${param.name}" />
		<c:if test="${errors.name}">이름을 입력하세요</c:if>
		</p>
		<p>
		암호 : <br /> <input type="password" name="password"  />
		<c:if test="${errors.password}">암호를 입력하세요</c:if>
		</p>
		<p>
		확인 : <br />	<input type="password" name="confirmPassword"  />
		<c:if test="${errors.confirmPassword}">확인을 입력하세요</c:if>
		<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
		</p>
		<input type="submit" value="가입" />
	</form>
</body>
</html>