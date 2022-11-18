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
    <title>상품 상세</title>

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
                <a class="navbar-brand text-light fw-bold fs-3" href="#">상품 상세</a>
            </div>
        </nav>

    <div class="form-floating mb-3 h-100">
        <table id="" class="table table-bordered">
            <tr class="form-floating mb-3 text-light" >
                <th>상품번호</th>
                <td colspan="1" id="product_no">${product.product_no}</td>
                <th>상품등록자</th>
                <td colspan="2">${product.product_adder}</td>
                <th>상품정보</th>
                <td colspan="6">${product.product_information}</td>
            </tr>

            <tr class="form-floating mb-3 text-light">
                <th>상품이름</th>
                <td colspan="6">${product.product_name}</td>
                <th>상품가격</th>
                <td colspan="2">${product.product_price}</td>
                <th>상품판매량</th>
                <td colspan="1">${product.product_rate}</td>
            </tr>

            <tr class="form-floating mb-3 text-light">
                <th>상품사진</th>
                <td colspan="12"><img src="${pageContext.request.contextPath}/image/upload/${product.product_photo}"></td>
            </tr>

            <tr class="form-floating mb-3 text-light">
                <th >상품설명</th>
                <td colspan="12">${product.product_description}</td>
            </tr>
        </table>

            <div class="form-floating mb-3 float-end">
                <input class="btn btn-dark btn-outline-light justify-content-end" type="button" class="btn btn-warning"
                       value="수정하기" onclick="location.href='/admin/product/toUpdate/${product.product_no}'">
                <input class="btn btn-dark btn-outline-light justify-content-end" id="deleteBtn" type="button" class="btn btn-danger"
                       value="삭제하기">
                <input class="btn btn-dark btn-outline-light justify-content-end" type="button" class="btn btn-primary"
                       value="목록보기" onclick="location.href='/admin/product/list'">
            </div>
    </div>

    <hr>
    <jsp:include page="../../admin/common/footer.jsp">
        <jsp:param name="footer" value="footer"/>
    </jsp:include>
</div>

<script>

    // del 객체 생성
    var del = {
        // 초기화(이벤트 등록) 메소드
        init: function() {

            var _this = this;
            const deleteBtn = document.querySelector('#deleteBtn');

            if (deleteBtn) {
                deleteBtn.addEventListener('click', _this.destroy);
            }
        },
        // 삭제 메소드
        destroy: function() {
            // url에서 id를 추출!
            var split = location.pathname.split('/');
            var id = split[split.length - 1];
            // 데이터 삭제 요청을 보냄
            // fetch(URL, HTTP_REQUEST)
            fetch('/api/v1/product/' + id, {
                method: 'DELETE',
            }).then(function(response) {
                if (response.ok) {
                    alert('글이 삭제 되었습니다.');
                    window.location.href='/admin/product/list';
                } else {
                    alert('글을 삭제할 수 없습니다.');
                }
            });
        }
    };
    //  객체 초기화
    del.init();

</script>
</body>
</html>


