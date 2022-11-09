<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script>
	function cancelBoard(){
		if (confirm("글 등록을 취소하시겠습니까?")){
			location.href="/board";
		} 
	}
</script>
</head>
<body>	
	<%@include file="../layouts/header.jsp"%>
	<form id="post_Form" action="/boardPost" method="post">
		제목 <input type="text" name="title" placeholder="제목을 작성해주세요" value=${boardDto.title }> ${valid_title }<br> 
		작성자 ${id } (${name }) <input type="hidden" name="userId" value="${id }"> <input type="hidden" name="writer" value="${name }"> <br>
		<textarea name="content" placeholder="문의 내용을 작성해주세요" >${boardDto.content }</textarea> ${valid_content }
		<br> <button onclick="saveBoard()">등록</button>
	</form>
	<button onclick="cancelBoard()">취소</button>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>