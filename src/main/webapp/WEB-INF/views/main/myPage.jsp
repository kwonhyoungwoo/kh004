<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%-- 헤더 파일 include --%>
<%@include file="../layouts/header.jsp" %>

<br>
<br>

<div class="section_login">
    <h3 class="tit_login">마이 페이지</h3>
</div>
<br><br><br><br>
<div id="contents">
    <c:choose>
        <c:when test="${success != null }">
            <c:choose>
                <c:when test="${success}">
                    <div> 회원 수정 성공</div>
                </c:when>
                <c:otherwise>
                    <div> 회원 수정 실패</div>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <div><a href="http://localhost/memberUpdate.html">
        <div>회원 수정</div>
    </a></div>
    <a href="/member/item">
        <div style="margin: 10px;">주문 내역</div>
    </a>
    <div style="margin: 10px;">배송지 관리</div>
    <a href="/board">
        <div style="margin: 10px;">도움이 필요하신가요?</div>
    </a>
</div>
<%-- 푸터 파일 include --%>
<%@include file="../layouts/footer.jsp" %>

