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
<script>
<%-- 비회원은 문의하기 접근시 로그인페이지로 이동됨 --%>
	function notMember(){
		if ("${msg}" === "not_login"){
			alert("로그인이 필요한 서비스입니다.");
			location.href="/login.html";
		} else{
			location.href="/boardPost";
		} 
	}
</script>
<body>
	<%@include file="../layouts/header.jsp"%>
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
					<td>${board.userId}</td>
					<td>${board.createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="notMember()">문의 하기</button>
	
	<%-- 페이징 처리 --%>
	<div>
		<c:forEach var='pageNum' items="${pageList }">
			<a href="?page= + ${pageNum}">${pageNum }</a>
		</c:forEach>
	</div>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>