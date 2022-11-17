<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../common/header.jsp" %>

<style>
    /*버튼*/
    input#btn-add {
        float: right;
        margin: 0 0 15px;
    }

    table tr.table-info:hover {
        cursor: pointer;
        color: #a8bdff;
    }

    #board-container {
        width: 70%;
        margin: 0 auto;
        padding-top: 3%;
    }

    .table > thead > tr > th {
        text-align: center;
    }

    .table > tbody > tr > td {
        text-align: center;
    }

    .table > tbody > tr > #title {
        text-align: left;
    }
</style>

<section id="board-container" class="container">

    <h2> 회원목록 조회 / 수정 </h2>
    </div>
    <div align="center">
        <table id="tbl-board" class="table table-bordered table-blue">
            <thead>
            <tr class="table-primary">
                <th width="5%" id="title"></th>
                <th width="10%">아이디</th>
                <th width="10%">비밀번호</th>
                <th width="10%">이름</th>
                <th width="10%">이메일</th>
                <th width="10%">휴대폰</th>
                <th width="10%">주소</th>
                <th width="15%">생년월일</th>
                <th width="10%">성별</th>

            </tr>
            </thead>
            <c:forEach var='member_tb' items="${memberList}">
                <tr>
                    <td></td>
                    <td><a href="/member/update/admin/${member_tb.id}">${member_tb.id}</a></td>

                    <td>${member_tb.password}</td>
                    <td>${member_tb.name}</td>

                    <td>${member_tb.email}</td>
                    <td>${member_tb.phone}</td>
                    <td>${member_tb.address}</td>
                    <td>${member_tb.birth}</td>
                    <td>${member_tb.gender}</td>
                    <td></td>
                </tr>
            </c:forEach>
            <tbody>
            <tbody>


            <%--            <c:forEach var='member_tb' items="${list}">--%>

            <%--            </c:forEach>--%>
            </tbody>


        </table>
    </div>


</section>

<%@ include file="../common/footer.jsp" %>