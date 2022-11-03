<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<form action="/boardPost" method="post">
		제목 <input type="text" name="title"> <br> 
		<textarea name="content"></textarea>
		<br> <input type="submit" value="등록">
	</form>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>