<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Hello Spring</title>
    <!-- 부트스트랩관련 라이브러리 -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</head>

<body>
<div id="container">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="" style="color:#ffb6c1">
                MarKey Kuly ADMIN
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <!-- 좌우정렬을 위해 mr-auto 추가 -->
                <ul class="navbar-nav mx-auto" >
                    <li class="nav-item"><a class="nav-link" href="/admin/memberList">회원목록-조회/수정</a></li>
                    <li class="nav-item"><a class="nav-link" href="/admin/productList">상품목록-조회/수정</a></li>
                    <li class="nav-item"><a class="nav-link" href="">Untitled</a></li>
                    <li class="nav-item"><a class="nav-link" href="">Untitled</a></li>
                    <li class="nav-item"><a class="nav-link" href="/admin/adminLogin">로그인(임시)</a></li>
                </ul>

            </div>
        </nav>
    </header>
</div>