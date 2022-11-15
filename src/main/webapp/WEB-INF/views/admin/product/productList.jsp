<%@ page language="java" contentType="text/html; charset=UTF-8"
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

<body>

<section id="board-container" class="container">

    <h2> 상품 추가 </h2>
    <tr>
        <td colspan="6" class="text-end">
            <input type="button" class="btn btn-warning" value="상품추가" onclick="location.href='/admin/productList/productListInsertView'">
        </td>
    </tr>
    <div align="center">
        <table id="tbl-board" class="table table-bordered table-blue">
            <thead>
                <tr class="table-primary">
                    <th width="10%" id="title">상품번호</th>
                    <th width="10%">상품이름</th>
                    <th width="10%">상품가격</th>
                    <th width="10%">상품정보</th>
                    <th width="10%">상품사진</th>
                    <th width="10%">상품설명</th>
                    <th width="10%">상품판매량</th>
                    <th width="10%">상품등록자</th>
                    <th width="10%">상품등록날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productList}" var="product" varStatus="status">
                    <tr onclick="location.href='/admin/productList/productListView/${product.product_no}'" class="table-info">
                        <td id="id">${product.product_no}</td>
                        <td>${product.product_name}</td>
                        <td>${product.product_price}</td>
                        <td>${product.product_information}</td>
                        <td>${product.product_photo}</td>
                        <td>${product.product_description}</td>
                        <td>${product.product_rate}</td>
                        <td>${product.product_adder}</td>
                        <td>${product.product_regdate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <c:forEach var='pageNum' items="${productPageList }">
            <a href="?page= + ${pageNum}">${pageNum }</a>
        </c:forEach>
    </div>

</section>



<%@ include file="../common/footer.jsp" %>