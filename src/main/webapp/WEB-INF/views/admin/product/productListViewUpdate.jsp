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
<section class="container" id="form">
    <div id="board-container"  class="table table-responsive">
        <form action="${pageContext.request.contextPath}/admin/productList/productListViewUpdate/${product_no}" method="post">
            <table id="" class="table table-bordered">
                <tr class="table-primary">
<%--                    <th>상품번호</th>--%>
<%--                    <td colspan="1"><input type="text" value="${productViewUpdate.product_no}" name="product_no"></td>--%>
                    <th>상품등록자</th>
                    <td colspan="2"><input type="text" value="${productListToUpdate.product_adder}" name="product_adder"></td>
                    <th>상품정보</th>
                    <td colspan="3"><input type="text" value="${productListToUpdate.product_information}" name="product_information"></td>
                </tr>

                <tr class="table-primary">
                    <th>상품이름</th>
                    <td colspan="6"><input type="text" value="${productListToUpdate.product_name}" name="product_name"></td>
                    <th>상품가격</th>
                    <td colspan="2"><input type="text" value="${productListToUpdate.product_price}" name="product_price"></td>
                </tr>

                <tr class="table-primary">
                    <th>상품사진</th>
                    <td colspan="6"><input type="text" value="${productListToUpdate.product_photo}" name="product_photo"></td>
                    <th>상품판매량</th>
                    <td colspan="2"><input type="text" value="${productListToUpdate.product_rate}" name="product_rate"></td>
                </tr>

                <tr class="table-primary">
                    <th class="table-primary">상품설명</th>
                    <td colspan="9"><input type="text" value="${productListToUpdate.product_description}" name="product_description"></td>
                </tr>
            </table>
            <input type="submit" class="btn btn-warning" value="저장하기" onclick="validate();">
        </form>
    </div>
</section>

</body>

<%@ include file="../common/footer.jsp" %>




