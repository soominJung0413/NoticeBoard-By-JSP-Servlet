<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@taglib prefix="pre" tagdir="/WEB-INF/tags" %>
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
<title>게시글 읽기</title>
</head>
<body>
<div class="container">
<table class="table table-hover">

<thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
    </tr>
  </thead>
  <tbody>
  <tr>
  <td> ${articleData.article.number} </td>
  <td> <c:out value="${articleData.article.title}" /> </td>
  <td> ${articleData.article.writer.name }</td>
  </tr>
  <tr>
  <th scope="row"/>
  	<td style="white-space: pre-wrap;">
  	<c:if test="${not empty articleData.content.fileName}">
  		<img width="30%" src="/images/${articleData.content.number}/${articleData.content.fileName}" alt="이미지 깨짐" />
  	</c:if>
  	<c:out value="${articleData.content.content }" />

  	</td>
  </tr>
  </tbody>
</table>

<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo }" />
 			<a href="list.do?pageNo${pageNo}" class="badge badge-light">[목록]</a>
 			<c:if test="${authUser.id == articleData.article.writer.id}">
				<a href="modify.do?no=${articleData.article.number }" class="badge badge-light">[게시글 수정]</a>
				<a href="delete.do?no=${articleData.article.number}" class="badge badge-light">[게시글 삭제]</a> 			
 			</c:if>

</div>

</body>
</html>