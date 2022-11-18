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
<%@ include file="../admin/common/header.jsp"%>
<link href="/css/board/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h5 class="list_title">회원 문의 내역</h5>
	<div class="table_wrap">
		<table class="table table-hover">
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
						<td class="board_td_title"><a href="/admin/board/${board.id}">${board.title}</a></td>
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
	<%-- 페이징 처리 !수정--%>
	<div class="boardList_page">
		<c:forEach var='pageNum' items="${pageList }">
			<a href="?page= + ${pageNum}">${pageNum }</a>
		</c:forEach>
	</div>
</body>
<%@ include file="../admin/common/footer.jsp"%>
</html>