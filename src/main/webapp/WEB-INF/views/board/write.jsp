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
		제목 <input type="text" name="title">
		<br>
		<c:choose>
			<c:when test="${id == null }">
				작성자 ID <input type="text" name="userId">
			</c:when>
			<c:otherwise>
				작성자 ID<input type="text" name="userId" value="${id}">
			</c:otherwise>
		</c:choose>
		<br>
		<c:choose>
			<c:when test="${name == null }">
				작성자 이름<input type="text" name="writer">
			</c:when>
			<c:otherwise>
				작성자 이름<input type="text" name="writer" value="${name}">
			</c:otherwise>
		</c:choose>

		<br> 내용 <br>
		<textarea name="content"></textarea>
		<br> <input type="submit" value="등록">
	</form>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>