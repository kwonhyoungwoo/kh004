<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nonmember</title>
<%@include file="../layouts/header.jsp"%>
</head>
<body>
	<div style="text-align:center; height: 500px; ">
		<h4 style="text-align: center; margin-top: 150px;">${msg }</h4>
		<button type="button" onclick="location.href='login.html'" class="btn btn-primary sm-btn">로그인하기</button>
	</div>
</body>
<%@include file="../layouts/footer.jsp"%>
</html>