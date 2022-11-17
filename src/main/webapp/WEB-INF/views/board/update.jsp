<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 수정</title>
<script>
<%-- confirm을 사용해서 ture 반환시 데이터 전송되도록 처리 --%>
 function editBoard() {
	if (confirm("해당 글을 수정하시겠습니까?")) {
		alert("글이 수정되었습니다.");
		edit_form.submit();
	}
}

 function canceledit() {
	if (confirm("수정한 내용이 저장되지 않습니다. 계속 진행하겠습니까?")) {
		location.href = "/board/${boardDto.id}"
	}
}
</script>
<%@include file="../layouts/header.jsp"%>
</head>
<body>
	<h5 class="list_title">문의 수정</h5>
	<div class="write_wrap">
		<form id="edit_form" action="/board/edit/${boardDto.id }" method="post" onsubmit="return false">
			<input type="hidden" name="id" value="${boardDto.id }" />
			<div class="row mb-3">
				<label for="inputEmail3" class="col-sm-2 col-form-label">제목</label>
				<div class="col-sm-10">
					<input type="text" name="title" class="board_form form-control" value="${boardDto.title }">
					<div class="board_valid form-text">${valid_title }</div>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="col-sm-2 col-form-label">작성자</label>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${boardDto.userId } (${boardDto.writer })">
					<input type="hidden" name="userId" value="${boardDto.userId }">
					<input type="hidden" name="writer" value="${boardDto.writer }">
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea name="content" class="form-control" rows="4">${boardDto.content }</textarea>
				<div class="board_valid form-text">${valid_content }</div>
			</div>
			<div class="write_button">
				<button onclick="editBoard()" class="btn btn-primary btn-sm">수정</button>
				<button onclick="canceledit()" class="btn btn-secondary btn-sm">취소</button>
			</div>
		</form>
	</div>
</body>
<%@include file="../layouts/footer.jsp"%>
</html>