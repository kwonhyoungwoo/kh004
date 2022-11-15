<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 헤더 파일 include --%>
<%@include file="../layouts/header.jsp"%>
<%-- 슬라이드 영역 --%>
<div class="slide_area">
	<ul class="slider_container simple-list" id="slider">
		<li class="slide"><img src="/image/slide_img_1.png"></li>
		<li class="slide"><img src="/image/slide_img_2.png"></li>
	</ul>
	<a href="#" id="prev"><i class="fa fa-caret-left fa-3x"></i></a> <a
		href="#" id="next"><i class="fa fa-caret-right fa-3x"></i></a>
</div>
<%-- 상품리스트 --%>
<div id="contents">
	<div class="list_slider">
		<h3>전체 상품<i class="fa fa-chevron-right"></i></h3>
		<a class="prev" href="#"><i class="fa fa-chevron-circle-left fa-4x"></i></a>	<%-- 왼쪽화살표아이콘 --%>
		<a class="next" href="#"><i class="fa fa-chevron-circle-right fa-4x"></i></a>	<%-- 오른쪽화살표아이콘 --%>
		<div class="item_wrap">
			<%--반복문으로 상품 리스트 출력 --%>
			<c:forEach items="${productList}" var="product">
				<div class="item">
					<a href="#">
						<div class="img_box">
							<img src="/image/123.png">
						</div>
						<div class="txt_box">
							<h4>${product.product_name}</h4>
							<fmt:formatNumber maxFractionDigits="3" value="${product.product_price}" var="product_price" />
							<p>${product_price}원</p>
						</div>
					</a>
				</div>
			</c:forEach>
			<%--끝나는 위치 --%>
		</div>
	</div>
	<div class="list_slider">
		<h3>이 상품 어때요?</h3>
		<a class="prev2" href="#"><i class="fa fa-chevron-circle-left fa-4x"></i></a>	
		<a class="next2" href="#"><i class="fa fa-chevron-circle-right fa-4x"></i></a>	
		<div class="item_wrap2">
			<c:forEach items="${productRecommend}" var="product">
				<div class="item">
					<a href="#">
						<div class="img_box">
							<img src="/image/123.png">
						</div>
						<div class="txt_box">
							<h4>${product.product_name}</h4>
							<fmt:formatNumber maxFractionDigits="3" value="${product.product_price}" var="product_price" />
							<p>${product_price}원</p>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="list_slider">
		<div class="cate_list">
			<h3 style="margin-bottom: 10px;">집에서 즐기는 ~~<i class="fa fa-chevron-right"></i></h3> <%-- 카테고리 상품 뿌려질곳 --%>
			<p>집에서 부담없이 즐기는 ~~~</p>
		</div>
		<a class="prev3" href="#"><i class="fa fa-chevron-circle-left fa-4x"></i></a>	
		<a class="next3" href="#"><i class="fa fa-chevron-circle-right fa-4x"></i></a>	
		<div class="item_wrap3">
			<c:forEach items="${productList}" var="product">
				<div class="item">
					<a href="#">
						<div class="img_box">
							<img src="/image/123.png">
						</div>
						<div class="txt_box">
							<h4>${product.product_name}</h4>
							<fmt:formatNumber maxFractionDigits="3" value="${product.product_price}" var="product_price" />
							<p>${product_price}원</p>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</div>	
<%-- 푸터 파일 include --%>
<%@include file="../layouts/footer.jsp"%>