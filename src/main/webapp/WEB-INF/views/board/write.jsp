<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<form action="/boardPost" method="post">
		제목 <input type="text" name="title"> <br> 작성자 <br>
		<%-- 수정 --%>
		<textarea name="content"></textarea>
		<br> <input type="submit" value="등록">
	</form>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>