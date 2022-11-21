<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 문의 상세보기</title>
<%@ include file="../admin/common/header.jsp"%>
<link href="/css/board/board.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/afa5bb7adf.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script>
function editRep() {
	if (confirm("해당 답변을 수정하시겠습니까?")) {
		alert("수정되었습니다.");
		rep_edit_form.submit();
	}
}

function deleteBoard() {
	if (confirm("해당 글을 삭제하시겠습니까?")) {
		alert("삭제되었습니다.");
		delete_form.submit();
	}
}	

function deleteRep() {
	if (confirm("해당 답변을 삭제하시겠습니까?")) {
		alert("삭제되었습니다.");
		rep_delete_form.submit();
	}
}	

</script>
</head>
<body>
	<h5 class="list_title">문의 내용</h5>
	<div class="container">
		<div class="row">
			<div class="board_detail">
				<div class="row">
					<h5 style="width: 1030px;" class="col-1">제목</h5>
					<p class="col-5">${boardDto.title}</p>
					<h5 class="col-1">작성자</h5>
					<p class="col-2">${boardDto.userId }(${boardDto.writer })</p>
					<h5 class="col-1">등록일</h5>
					<p class="col-2">
						<fmt:parseDate value="${boardDto.createDate }" var="createDate" pattern="yyyy-MM-dd'T'HH:mm" />
						<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd HH:mm" />
					</p>
				</div>
				<hr class="detail_hr">
				<div>
					<p class="board_detail_p">${boardDto.content}</p>
				</div>
				<hr>
					<div class="board_detail_list">
						<form id="delete_form" action="/admin/board/${boardDto.id}" method="post" onsubmit="return false">
							<button class="btn btn-danger delete-btn btn-sm" onclick="deleteBoard()">삭제</button>
						</form>
					</div>
				<button onclick="location.href='/admin/board'" class="admin_detail_list btn btn-secondary btn-sm" type="button">글목록</button>
			</div>
		</div>
		<%-- 답변 영역 --%>
		<div class="rep_wrap card card-body">
			<c:forEach var="rep" items="${boardDto.repList }">
				<p class="board_detail_repid">
						관리자
						<fmt:parseDate value="${rep.createDate }" var="createDate" pattern="yyyy-MM-dd'T'HH:mm" />
						<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd HH:mm" />
						<button class="rep_edit btn btn-link btn-sm" data-toggle="collapse" data-target=".rep_edit_${rep.id }">
							<i class="fa fa-pencil"></i>
						</button>
						<button onclick="deleteRep()" class="rep_delete btn btn-link btn-sm">
							<i class="fa fa-trash-o"></i>
						</button>
						<form id="rep_delete_form" action="/delete/${rep.id}/${boardDto.id}" method="post" onsubmit="return false"></form>
				<div class="collapse rep_edit_${rep.id } show">
					${rep.content }
				</div>
				<div class="collapse rep_edit_${rep.id }">
					<form id="rep_edit_form" action="/edit/${rep.id}/${boardDto.id}" method="post" onsubmit="return false">
						<textarea name="content" class="form-control" rows="2">${rep.content }</textarea>
						<button onclick="editRep()" class="admin_repPost btn btn-secondary update-btn btn-sm">수정하기</button>
					</form>
				</div>
				<hr>
			</c:forEach>
			<form action="/admin/rep/write/${boardDto.id }" method="post">
				<div>
					<textarea name="content" class="form-control" placeholder="내용을 작성해주세요." rows="2"></textarea>
					<button type="submit" class="admin_repPost btn btn-secondary update-btn btn-sm">답변등록</button>
				</div>
			</form>
		</div>
	</div>
	<%-- 답변 영역 끝 --%>
	<%@ include file="../admin/common/footer.jsp"%>
</body>
</html>