<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../common/header.jsp" %>

    <meta charset="UTF-8">
    <title>Hello Spring</title>
    <!-- 부트스트랩관련 라이브러리 -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>


    <style>
        /*글쓰기버튼*/
        input#btn-add{float:right; margin: 0 0 15px;}
        table tr.table-info:hover{cursor:pointer; color: #a8bdff;}

        #board-container {width: 70%; margin: 0 auto; padding-top: 3%;}
        .table > thead > tr > th {text-align: center;}
        .table > tbody > tr > td {text-align: center;}
        .table > tbody > tr > #title {text-align: left;}
    </style>

</head>

<body>

<section id="board-container" class="container">

        <h2> 상품목록 조회 / 수정 </h2>
    </div>
    <div  align="center" >
        <table id ="tbl-board" class="table table-bordered table-blue">
            <thead>
                <tr class="table-primary">
                    <th width="10%">상품번호</th>
                    <th width="10%">상품이름</th>
                    <th width="10%">상품가격</th>
                    <th width="10%">상품정보</th>
                    <th width="10%">상품사진</th>
                    <th width="10%">상품설명</th>
                    <th width="10%">상품 판매량</th>
                    <th width="10%">상품등록자</th>
                    <th width="10%">상품등록날짜</th>
                </tr>
            </thead>
    <tbody>

    <%--            <c:forEach var='member_tb' items="${list}">--%>
                <tr class="table-info">
                    <td id="id">1111</td>
                    <td>2222</td>
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