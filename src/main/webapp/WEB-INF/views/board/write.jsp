<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 등록</title>
<%@include file="../layouts/header.jsp"%>
<script>
function cancelBoard() {
	if (confirm("글 등록을 취소하시겠습니까?")) {
		location.href = "/board";
	}
}
</script>
</head>
<body>
	<h5 class="list_title">문의 등록</h5>
	<div class="write_wrap">
		<form id="post_Form" action="/boardPost" method="post">
			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-2 col-form-label">제목</label>
				<div class="col-sm-10">
					<input type="text" name="title" placeholder="제목을 작성해주세요"
						class="board_form form-control" value=${boardDto.title }>
					<div id="passwordHelpBlock" class="board_valid form-text">${valid_title }</div>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="col-sm-2 col-form-label">작성자</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="staticEmail" value="${id } (${name })"> <input
						type="hidden" name="userId" value="${id }"> <input
						type="hidden" name="writer" value="${name }">
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea name="content" class="form-control"
					placeholder="문의 내용을 작성해주세요" rows="4">${boardDto.content }</textarea>
				<div id="passwordHelpBlock" class="board_valid form-text">${valid_content }</div>		
			</div>
			<div class="write_button">
				<button onclick="saveBoard()" class="btn btn-primary btn-sm">등록</button>
				<button onclick="cancelBoard()" class="btn btn-secondary btn-sm"
					type="button">취소</button>
			</div>
		</form>
	</div>
</body>
<%@include file="../layouts/footer.jsp"%>
</html>