<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<h2>${boardDto.title }</h2>
	<h5>작성자 ${boardDto.writer }</h5>
	<span>${boardDto.createDate }</span>
	<p>${boardDto.content }</p>

	<%--수정, 삭제 --%>
	<div>
		<a href="/board/edit/${boardDto.id}">
			<button>수정</button>
		</a>

		<form id="delete_form" action="/board/${boardDto.id }" method="post">
			<input type="hidden" value="delete" />
			<button id="delete_btn">삭제</button>
		</form>
	</div>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>