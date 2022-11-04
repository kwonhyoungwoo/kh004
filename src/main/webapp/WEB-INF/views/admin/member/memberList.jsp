<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../common/header.jsp" %>

    <style>
        /*버튼*/
        input#btn-add{float:right; margin: 0 0 15px;}
        table tr.table-info:hover{cursor:pointer; color: #a8bdff;}

        #board-container {width: 70%; margin: 0 auto; padding-top: 3%;}
        .table > thead > tr > th {text-align: center;}
        .table > tbody > tr > td {text-align: center;}
        .table > tbody > tr > #title {text-align: left;}
    </style>

<section id="board-container" class="container">

        <h2> 회원목록 조회 / 수정 </h2>
    </div>
    <div  align="center">
        <table id ="tbl-board" class="table table-bordered table-blue">
            <thead>
                <tr class="table-primary">
                    <th width="5%" id="title">번호</th>
                    <th width="10%" >아이디</th>
                    <th width="10%">비밀번호</th>
                    <th width="10%">닉네임</th>
                    <th width="10%">이름</th>
                    <th width="10%">전화</th>
                    <th width="15%">주소</th>
                    <th width="10%">우편번호</th>
                    <th width="10%">가입날짜</th>
                </tr>
            </thead>
<%--            <c:forEach var='member_tb' items="${list}">--%>
<%--                <tr>--%>
<%--                    <td>${member_tb.no}</td>--%>
<%--                    <td>${member_tb.id}</td>--%>
<%--                    <td>${member_tb.password}</td>--%>
<%--                    <td>${member_tb.nickname}</td>--%>
<%--                    <td>${member_tb.name}</td>--%>
<%--                    <td>${member_tb.phone}</td>--%>
<%--                    <td>${member_tb.address}</td>--%>
<%--                    <td>${member_tb.zip_code}</td>--%>
<%--                    <td>${fn:substring(member_tb.joindateS,0,10)}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
            <tbody>


<%--            <c:forEach var='member_tb' items="${list}">--%>
                <tr class="table-info">
                    <td>1111</td>
                    <td id="id">2222</td>
                    <td>3333</td>
                    <td>4444</td>
                    <td>5555</td>
                    <td>6666</td>
                    <td>7777</td>
                    <td>8888</td>
                    <td>9999</td>
                </tr>
            <%--            </c:forEach>--%>
            </tbody>


        </table>
    </div>








</section>

<%@ include file="../common/footer.jsp" %>