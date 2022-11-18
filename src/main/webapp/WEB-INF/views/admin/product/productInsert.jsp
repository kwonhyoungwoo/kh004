<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <title>상품 추가 페이지</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">

</head>
<body class="d-flex text-bg-dark">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <jsp:include page="../../admin/common/header.jsp">
        <jsp:param name="header" value="header"/>
    </jsp:include>

    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand text-light fw-bold fs-3" href="#">상품 추가</a>
        </div>
    </nav>

    <form>
        <div class="form-floating mb-3 h-100">
            <input type="text" class="form-control" id="product_adder" name="product_adder" placeholder="상품 등록자" required>
            <label for="product_adder" class="text-black-50">상품 등록자 입력하세요</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="product_information" name="product_information" placeholder="상품 정보" required>
            <label for="product_information" class="text-black-50">상품 정보를 입력하세요</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="product_name" name="product_name" placeholder="상품 이름" required>
            <label for="product_name" class="text-black-50">상품 이름을 입력하세요</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="product_price" name="product_price" placeholder="상품 가격" required>
            <label for="product_price" class="text-black-50">삼품 가격을 입력하세요</label>
        </div>
        <div class="input-group mb-3">
            <input type="file" class="form-control" name="file" id="file" accept="*">
            <label class="input-group-text" for="file">상품 이미지 업로드</label>
        </div>
        <div class="form-floating mb-3">
            <textarea class="form-control" id="summernote" name="product_description" placeholder="상품 설명" required></textarea>
        </div>
        <div class="form-floating mb-3 float-end">
            <a class="btn btn-dark btn-outline-light justify-content-end" href="${pageContext.request.contextPath}/admin/product/list">취소</a>
            <button class="btn btn-dark btn-outline-light justify-content-end" type="button" onclick="save();">등록</button>
        </div>
    </form>

    <hr>

    <jsp:include page="../../admin/common/footer.jsp">
        <jsp:param name="footer" value="footer"/>
    </jsp:include>
</div>

<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            placeholder : "내용을 입력하세요.",
            tabsize: 2,
            height: 500,
            lang: 'ko-KR',
            focus: true,
        });
    });

    function save() {
        let file = $("#file")[0].files[0];
        let formData = new FormData();
        formData.append('file', file);

        const data = {
            product_adder : $("#product_adder").val(),
            product_information : $("#product_information").val(),
            product_name : $("#product_name").val(),
            product_price : $("#product_price").val(),
            product_description : $("#summernote").val()
        }

        formData.append("productDto", new Blob([JSON.stringify(data)], {type : "application/json"}));

        if(!data.product_adder || data.product_adder.trim() === "" || !data.product_information || data.product_information.trim() === "" ||
            !data.product_name || data.product_name.trim() === "" || !data.product_price || data.product_price.trim() === "" ||
            !data.product_description || data.product_description.trim() === "") {
                alert("공백 또는 입력하지 않은 부분이 있습니다.");
            return false;

        } else {
            // alert("1");
            $.ajax({
                type : "post",
                url : "/api/v1/product",
                // contentType: "application/json; charset=utf-8",
                data : formData,
                dataType : "json",
                processData : false,
                contentType : false,
                enctype : 'multipart/form-data',
                success : function(res) {
                    // alert("2");
                    alert("상품이 등록 되었습니다.");
                    location.href = "/admin/product/list";
                },
                error : function(res) {
                    alert("아하 여기구나");
                    location.href = "/admin/product/list";
                }
            })
        }
    }


</script>
</body>
</html>
