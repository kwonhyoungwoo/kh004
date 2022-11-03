<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<link href="css/board/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<a href="/boardPost">글쓰기</a>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='board' items="${boardList}">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board/${board.id}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>