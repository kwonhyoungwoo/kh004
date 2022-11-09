<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script>
	function deleteBoard(){
		if (confirm("해당글을 삭제하시겠습니까?")){
			alert("글이 삭제되었습니다.");
			delete_form.submit();
		} 
	}
</script>
</head>
<body>
	<%@include file="../layouts/header.jsp"%>
	<h2>${boardDto.title }</h2>
	<h5>작성자 ${boardDto.userId } (${boardDto.writer })</h5>
	<span>${boardDto.createDate }</span>
	<p>${boardDto.content }</p>
	<button onclick="location.href='/board'">글목록</button>
	<%--로그인된 아이디랑 작성자가 동일해야 수정, 삭제 가능 --%>
	<c:if test="${sessionScope.id == boardDto.userId}">
		<div>
			<button onclick="location.href='/board/edit/${boardDto.id}'">수정</button>
			<%-- onsubmit에 return false 값을 넣어서 button를 눌러도 action이 실행되지 않게함 --%>
			<form id="delete_form" action="/board/${boardDto.id }" method="post" onsubmit="return false">
				<button onclick="deleteBoard()">삭제</button>
			</form>
		</div>
	</c:if>
	<%@include file="../layouts/footer.jsp"%>
</body>
</html>