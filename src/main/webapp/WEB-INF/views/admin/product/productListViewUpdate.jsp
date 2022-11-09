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
<script>
    // function validate(){
    //
    //     var adder = $("[name=adder]").val();
    //     var information = $("[name=no]").val();
    //     var name = $("[name=no]").val();
    //     var price = $("[name=no]").val();
    //     var photo = $("[name=no]").val();
    //     var rate = $("[name=no]").val();
    //     var description = $("[name=no]").val();
    //
    //     if(adder.trim().length==0){
    //         alert("제목을 입력하세요");
    //         return false;
    //     }
    //     else if(information.trim().length==0){
    //         alert("내용을 입력하세요");
    //         return false;
    //     }
    //     else{
    //         console.log("여기 오긴 오냐");
    //         location.href = "/admin/productList/productListView?no=";
    //         return true;
    //     }
    // }

    <%--$(function(){--%>
    <%--    $("#form").on("click", function(){--%>
    <%--        var no = $("#no").val();--%>
    <%--        var adder = $("#adder").val();--%>
    <%--        var information = $("#information").val();--%>
    <%--        var name = $("#name").val();--%>
    <%--        var price = $("#price").val();--%>
    <%--        var photo = $("#photo").val();--%>
    <%--        var rate = $("#rate").val();--%>
    <%--        var description = $("#description").val();--%>


    <%--        var params ={--%>
    <%--            no : $("#no").val(),--%>
    <%--            adder : $("#adder").val(),--%>
    <%--            information : $("#information").val(),--%>
    <%--            name : $("#name").val(),--%>
    <%--            price : $("#price").val(),--%>
    <%--            photo : $("#photo").val(),--%>
    <%--            rate : $("#rate").val(),--%>
    <%--            description : $("#description").val()--%>
    <%--        }--%>

    <%--        console.log("ListVieWUpdateAJAX 여기오냐");--%>
    <%--        console.log(no);--%>
    <%--        console.log(adder);--%>
    <%--        console.log(information);--%>
    <%--        console.log(name);--%>
    <%--        console.log(price);--%>
    <%--        console.log(photo);--%>
    <%--        console.log(rate);--%>
    <%--        console.log(description);--%>
    <%--        console.log();--%>

    <%--        $.ajax({--%>
    <%--            url : "${pageContext.request.contextPath}/admin/product/productListViewUpdateEnd?no="${productViewUpdate.product_no},--%>
    <%--            data : params--%>
    <%--        });--%>
    <%--    });--%>
    <%--});--%>


</script>-
<body>

<title> 상품목록 - 상세보기</title>
</head>
<section class="container" id="form">
    <div id="board-container"  class="table table-responsive">
        <form action="${pageContext.request.contextPath}/admin/productList/productListViewUpdateEnd">
            <table id="" class="table table-bordered">
                <tr class="table-primary">
                    <th>상품번호</th>
                    <td colspan="1"><input type="text" value="${productViewUpdate.product_no}" id="no"></td>
                    <th>상품등록자</th>
                    <td colspan="2"><input type="text" value="${productViewUpdate.product_adder}" id="adder"></td>
                    <th>상품정보</th>
                    <td colspan="3"><input type="text" value="${productViewUpdate.product_information}" id="information"></td>
                </tr>

                <tr class="table-primary">
                    <th>상품이름</th>
                    <td colspan="6"><input type="text" value="${productViewUpdate.product_name}" id="name"></td>
                    <th>상품가격</th>
                    <td colspan="2"><input type="text" value="${productViewUpdate.product_price}" id="price"></td>
                </tr>

                <tr class="table-primary">
                    <th>상품사진</th>
                    <td colspan="6"><input type="text" value="${productViewUpdate.product_photo}" id="photo"></td>
                    <th>상품판매량</th>
                    <td colspan="2"><input type="text" value="${productViewUpdate.product_rate}" id="rate"></td>
                </tr>

                <tr class="table-primary">
                    <th class="table-primary">상품설명</th>
                    <td colspan="9"><input type="text" value="${productViewUpdate.product_description}" id="description"></td>
                </tr>
            </table>
            <input type="submit" class="btn btn-warning" value="저장하기" onclick="validate();">
        </form>
    </div>
</section>

</body>

<%@ include file="../common/footer.jsp" %>




