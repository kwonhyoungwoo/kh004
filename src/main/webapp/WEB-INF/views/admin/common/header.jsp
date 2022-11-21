<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<%--    <script src="/js/script.js"></script>--%>
    <link href="/css/cover.css" rel="stylesheet">

    <link href="/css/summernote/summernote-lite.min.css" rel="stylesheet">
    <script src="/js/summernote/summernote-lite.min.js"></script>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/cover/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</head>

<header class="mb-auto text-bg-dark">
    <div>
        <h3 class="float-md-start mb-0">관리자 페이지</h3>
        <nav class="nav nav-masthead justify-content-center float-md-end">
            <a id="header-nav-1" class="nav-link fw-bold py-1 px-0" aria-current="page" href="/admin/main">Home</a>
            <a id="header-nav-2" class="nav-link fw-bold py-1 px-0" href="${pageContext.request.contextPath}/member/list">회원게시판</a>
            <a id="header-nav-3" class="nav-link fw-bold py-1 px-0" href="${pageContext.request.contextPath}/admin/product/list">상품게시판</a>
            <a id="header-nav-4" class="nav-link fw-bold py-1 px-0" href="${pageContext.request.contextPath}/admin/board">회원문의</a>
            <a id="header-nav-5" class="nav-link fw-bold py-1 px-0" href="#">Contact</a>
        </nav>
    </div>
</header>

</html>