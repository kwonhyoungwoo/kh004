<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<form action="/board/edit/${boardDto.id }" method="post">
		<input type="hidden" name="_method" value="put" /> <input
			type="hidden" name="id" value="${boardDto.id }" /> 제목 : <input
			type="text" name="title" value="${boardDto.title }"> <br>
		작성자 : <input name="writer" value="${boardDto.writer }"><br>
		<textarea name="content">${boardDto.content }</textarea>
		<br> <input type="submit" value="수정">
	</form>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>