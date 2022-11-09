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
	function canceledit(){
		if (confirm("수정한 내용이 저장되지 않습니다. 계속 진행하겠습니까?")){
			location.href="/board/${boardDto.id}"
		}
	}
</script>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<form id="edit_form" action="/board/edit/${boardDto.id }" method="post" onclick="return false">
		<input type="hidden" name="id" value="${boardDto.id }" /> 
		제목 <input type="text" name="title" value="${boardDto.title }"> <br>
		작성자 ${boardDto.userId } (${boardDto.writer })
		<input type= "hidden" name="userId" value="${boardDto.userId }"> 
		<input type= "hidden" name="writer" value="${boardDto.writer }"> <br>
		<textarea name="content">${boardDto.content }</textarea> <br> 
		<button onclick="editBoard()">수정</button>
	</form>
	<button onclick="canceledit()">취소</button>
	<button onclick="location.href='/board'">글목록</button>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>