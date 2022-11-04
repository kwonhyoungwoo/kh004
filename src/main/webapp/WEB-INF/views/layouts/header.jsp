<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<%--ICON 불러오기 --%>
<script src="https://kit.fontawesome.com/afa5bb7adf.js" crossorigin="anonymous"></script>
<head>
<%-- 부트스트랩 CSS --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%-- CSS파일 --%>
<link href="css/main/index.css" rel="stylesheet" type="text/css">
<link href="css/main/header.css" rel="stylesheet" type="text/css">
<link href="css/main/footer.css" rel="stylesheet" type="text/css">
<%-- jQuery 불러오기 --%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- JS 파일 -->
<script type="text/javascript" src="/js/main/index.js" ></script>
<meta charset="UTF-8">
<title>.</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<%-- 헤더 윗부분 --%>
			<div id="header_top">
				<ul class="nav">
				<%--Session에 따라 로그인, 로그아웃 출력 --%>
				<c:if test="${member == null }">
					<li><a href="join.html">회원가입</a></li>
					<li>|</li>
					<li><a href="login.html">로그인</a></li>
					<li>|</li>
				</c:if>
				<c:if test="${member != null }">
					<li>환영합니다! ${name}님 </li>
					<li><a href="/logout">로그아웃</a></li>
					<li>|</li>
				</c:if>
				<li><a href="#">고객센터</a></li>
				</ul>
			</div>
			<%-- 헤더 중간 --%>
			<div id="header_mid">
				<h1 class="logo">
					<a href="/"><img src="/image/logo.png"></a>
				</h1>
				<div class="search_box">
					<form action="#" method="get">
						<input name="" class="" type="search" placeholder="검색어를 입력해주세요"> 
						<button type="submit"><i class="fa fa-search"></i></button>
					</form>	
				</div>
				<div class="cart">
					<ul>
						<li><a href="#"><i class="fa fa-shopping-cart fa-2x"></i></a></li>
					</ul>
				</div>
			</div>
			<%-- 헤더 바닥 --%>
			<div id="header_bot">
				<div class="menu_bar">
					<ul>
						<li><a href="#"><i class="fa fa-list"></i>전체 카테고리</a>
							<div class="sub_menu_1">
								<ul>
									<li><a href="#">야채</a></li>
									<li><a href="#">과일</a></li>
									<li><a href="#">간식</a></li>
								</ul>
							</div>
						</li>	
						<li><a href="#">전체 상품</a></li>
						<li><a href="#">베스트</a></li>
						<li><a href="#">알뜰상품</a></li>
						<li><a href="#">특가혜택</a></li>
					</ul>
				</div>
			</div>
		</header>
	</div>