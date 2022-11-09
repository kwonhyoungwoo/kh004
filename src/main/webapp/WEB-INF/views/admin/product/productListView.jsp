<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../common/header.jsp" %>
<style>
    div#board-container{width:1000px; margin:0 auto; text-align:center;}
    div#board-container{margin-top:40px;}
</style>
<body>

<title> 상품목록 - 상세보기</title>
</head>
<section class="container">
    <div id="board-container"  class="table table-responsive">
        <table id="" class="table table-bordered">
            <tr class="table-primary">
                <th>상품번호</th>
                <td colspan="1">${productListView.product_no}</td>
                <th>상품등록자</th>
                <td colspan="2">${productListView.product_adder}</td>
                <th>상품정보</th>
                <td colspan="3">${productListView.product_information}</td>
            </tr>

            <tr class="table-primary">
                <th>상품이름</th>
                <td colspan="6">${productListView.product_name}</td>
                <th>상품가격</th>
                <td colspan="2">${productListView.product_price}</td>
            </tr>

            <tr class="table-primary">
                <th>상품사진</th>
                <td colspan="6">${productListView.product_photo}</td>
                <th>상품판매량</th>
                <td colspan="2">${productListView.product_rate}</td>
            </tr>

            <tr class="table-primary">
                <th class="table-primary">상품설명</th>
                <td colspan="9">${productListView.product_description}</td>
            </tr>
        </table>
        <tr>
            <td colspan="6" class="text-center">
                <input type="button" class="btn btn-warning" value="수정하기" onclick="location.href='/admin/productList/productListViewUpdate?no=${productListView.product_no}'">
                <input type="button" class="btn btn-danger" value="삭제하기" onclick="location.href='/admin/productList/productDelete?no=${productListView.product_no}'">
                <input type="button" class="btn btn-primary" value="목록보기" onclick="location.href='/admin/productList'">
            </td>
        </tr>
    </div>
</section>

</body>

<%@ include file="../common/footer.jsp" %>




