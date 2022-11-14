<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 상세보기</title>
<%@include file="../layouts/header.jsp"%>
<script>
function deleteBoard() {
	if (confirm("해당 글을 삭제하시겠습니까?")) {
		alert("글이 삭제되었습니다.");
		delete_form.submit();
	}
}	
</script>
</head>
<body>
	<h5 class="list_title">문의 내용</h5>
	<div class="container">
		<div class="row">
			<div class="board_detail">
				<div class="admin_board_list row">
					<h5 class="col-1">제목</h5>
					<p class="col-5">${boardDto.title}</p>
					<h5 class="col-1">작성자</h5>
					<p class="col-2">${boardDto.userId }(${boardDto.writer })</p>
					<h5 class="col-1">등록일</h5>
					<p class="col-2">
						<fmt:parseDate value="${boardDto.createDate }" var="createDate"
							pattern="yyyy-MM-dd'T'HH:mm" />
						<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd HH:mm" />
					</p>
				</div>
				<hr class="detail_hr">
				<div>
					<p class="board_detail_p">${boardDto.content}</p>
				</div>
				<hr>
				<%--로그인된 아이디랑 작성자가 동일해야 수정, 삭제 가능 --%>
				<c:if test="${sessionScope.id == boardDto.userId}">
					<div class="board_detail_list">
						<%-- onsubmit에 return false 값을 넣어서 button를 눌러도 action이 실행되지 않게함 --%>
						<form id="delete_form" action="/board/${boardDto.id }"
							method="post" onsubmit="return false">
							<button class="btn btn-danger delete-btn btn-sm" onclick="deleteBoard()">삭제</button>
						</form>
						<button class="btn btn-primary update-btn btn-sm" onclick="location.href='/board/edit/${boardDto.id}'">수정</button>
					</div>
				</c:if>
				<button onclick="location.href='/board'"
					class="board_edit_list btn btn-secondary btn-sm" type="button">글목록</button>
			</div>
		</div>
		<hr>
		<%-- 답변 영역 --%>
		<p>
			<button class="btn btn-success btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
				등록된 답변
			</button>
		</p>
		<div class="collapse show" id="collapseExample">
			<div class="card card-body">
				<c:forEach var="rep" items="${boardDto.repList }">
					<p class="board_detail_repid">
						관리자
						<fmt:parseDate value="${rep.createDate }" var="createDate" pattern="yyyy-MM-dd'T'HH:mm" /> 
						<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd HH:mm" />
					</p>
					<p class="board_detail_repContent">${rep.content }</p>
					<hr>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
<%@include file="../layouts/footer.jsp"%>
</html>