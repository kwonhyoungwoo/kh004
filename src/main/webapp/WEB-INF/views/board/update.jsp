<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<script>
<%-- confirm을 사용해서 ture 반환시 데이터 전송되도록 처리 --%>
	function editBoard(){
		if (confirm("해당글을 수정하시겠습니까?")){ 
			alert("글이 수정되었습니다.");
			edit_form.submit();
		} 
	}
</script>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<form id="edit_form" action="/board/edit/${boardDto.id }" method="post" onclick="return false">
		<input type="hidden" name="id" value="${boardDto.id }"> 
		제목 : <input type="text" name="title" value="${boardDto.title }"> <br>
		작성자 <input type ="hidden" name="writer" value="${boardDto.writer }"> ${boardDto.writer } <br>
		<textarea name="content">${boardDto.content }</textarea>
		<br> <button onclick="editBoard()">수정</button>
	</form>
	<a href="/board/${boardDto.id}">취소</a>
	<button onclick="location.href='/board'">글목록</button>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>