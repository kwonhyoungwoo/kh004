<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 문의 내역</title>
<link href="/css/board/board.css" rel="stylesheet" type="text/css">
</head>
<body class="d-flex text-center text-bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
	<%@ include file="../admin/common/header.jsp"%>
	<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <h5 class="navbar-brand text-light fw-bold fs-3">회원 문의 내역</h5>
        </div>
    </nav>
	<div>
		 <table class="table table-hover table-dark text-center">
			<thead>
				<tr>
					<th width="60%">제목</th>
					<th width="10%">작성자</th>
					<th width="10%">날짜</th>
					<th width="10%">답변 여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='board' items="${boardList}">
					<tr>
						<td><a style="color: white; text-decoration: none;" href="/admin/board/${board.id}">${board.title}</a></td>
						<td>${board.userId}</td>
						<td>
							<fmt:parseDate value="${board.createDate}" var="createDate" pattern="yyyy-MM-dd'T'HH:mm" /> 
							<fmt:formatDate value="${createDate }" pattern="yyyy/MM/dd" />
						</td>
						<c:choose>
							<c:when test='${fn:length(board.repList) == 0 }'>
								<td>답변 대기</td>
							</c:when>
							<c:otherwise>
								<td>답변 완료</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%-- 페이징 처리 --%>
	<nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
			<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="page">
				<li class="page-item">
					<a style="color: gray; text-decoration: none;" class="page-link" href="?page=${page-1}">${page}</a>
				</li>
			</c:forEach>
        </ul>
    </nav>
<%@ include file="../admin/common/footer.jsp"%>
</div>
</body>
</html>