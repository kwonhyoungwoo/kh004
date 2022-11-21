<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역</title>
<%@include file="../layouts/header.jsp"%>
</head>
<body class="list_body">
	<h5 class="list_title">문의 내역</h5>
	<c:choose>
		<c:when test="${empty boardList }">
			<div class="empty_wrap">
				<p>등록된 글이 없습니다.</p>
				<p>도움이 필요하신가요? <button class="btn btn-primary btn-sm" onclick="location.href='/board/post'">문의 하기</button> </p>
			</div>
		</c:when>
		<c:otherwise>
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
								<td class="board_td_title"><a href="/board/${board.id}">${board.title}</a></td>
								<td>${board.userId}</td>
								<td><fmt:parseDate value="${board.createDate}"
										var="createDate" pattern="yyyy-MM-dd'T'HH:mm" /> <fmt:formatDate
										value="${createDate }" pattern="yyyy/MM/dd" /></td>
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
				<button class="post_button btn btn-primary btn-sm" onclick="location.href='/board/post'">문의 하기</button> <br>
			</div>
			<%-- 페이징 처리 --%>
			<div class="page_button">
				<c:choose>
					<c:when test="${hasPrev == false }">
						<a class="page_prev"><i style="color: #d3d3d3;" class="fa fa-caret-square-o-left fa-2x"></i></a>
							<c:if test="${hasNext == false }">
								<a class="page_next"><i style="color: #d3d3d3;" class="fa fa-caret-square-o-right fa-2x"></i></a>	
							</c:if>
							<c:if test="${hasNext == true }">
								<a class="page_next" href="?page=${next}"><i style="color: gray;" class="fa fa-caret-square-o-right fa-2x"></i></a>		
							</c:if>	
					</c:when>
					<c:when test="${hasNext == false }">
						<c:if test="${hasPrev == true }">
							<a class="page_prev" href="?page=${prev}"><i style="color: gray;" class="fa fa-caret-square-o-left fa-2x"></i></a>
						</c:if>	
						<c:if test="${hasPrev == false }">
							<a class="page_prev"><i style="color: #d3d3d3;" class="fa fa-caret-square-o-left fa-2x"></i></a>
						</c:if>
						<a class="page_next"><i style="color: #d3d3d3;" class="fa fa-caret-square-o-right fa-2x"></i></a>	
					</c:when>
					<c:otherwise>
						<a class="page_prev" href="?page=${prev}"><i style="color: gray;" class="fa fa-caret-square-o-left fa-2x"></i></a>
						<a class="page_next" href="?page=${next}"><i style="color: gray;" class="fa fa-caret-square-o-right fa-2x"></i></a>		
					</c:otherwise>
				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>
<%@include file="../layouts/footer.jsp"%>