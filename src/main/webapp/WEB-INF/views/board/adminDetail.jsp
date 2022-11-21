<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 문의 상세</title>
<script src="https://kit.fontawesome.com/afa5bb7adf.js" crossorigin="anonymous"></script>
<link href="/css/board/board.css" rel="stylesheet" type="text/css">
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
<body class="d-flex text-bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
<%@ include file="../admin/common/header.jsp"%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <h5 class="navbar-brand text-light fw-bold fs-3">문의 내용</h5>
        </div>
    </nav>
	<div class="container">
		<div class="row">
			<div class="board_detail">
				<div class="row">
					<h5 width="30%">제목</h5>
					<p class="col">${boardDto.title}</p>
					<div class="row">
						<h5 class="col-2">작성자</h5>
						<p class="col-4">${boardDto.userId }(${boardDto.writer })</p>
						<h5 class="col-2">등록일</h5>
						<p class="col-4">
							<fmt:parseDate value="${boardDto.createDate }" var="createDate" pattern="yyyy-MM-dd'T'HH:mm" />
							<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd HH:mm" />
						</p>
					</div>
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
		<div class="rep_wrap card card-body text-bg-dark">
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
						<textarea name="content" class="form-control text-bg-dark" rows="2">${rep.content }</textarea>
						<button onclick="editRep()" class="admin_repPost btn btn-secondary update-btn btn-sm">수정하기</button>
					</form>
				</div>
			</c:forEach>
			<c:if test="${fn:length(boardDto.repList) == 0 }">		
			<form action="/admin/rep/write/${boardDto.id }" method="post">
				<div>
					<textarea name="content" class="form-control text-bg-dark" placeholder="내용을 작성해주세요." rows="2"></textarea>
					<button type="submit" class="admin_repPost btn btn-secondary update-btn btn-sm">답변등록</button>
				</div>
			</form>
			</c:if>
		</div>
	</div>
	<%-- 답변 영역 끝 --%>
<%@ include file="../admin/common/footer.jsp"%>
</div>
</body>
</html>