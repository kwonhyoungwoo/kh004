<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 헤더 파일 include --%>
<%@include file ="../layouts/header.jsp" %>
<%-- 슬라이드 영역 --%>
	<div class="slide_area">
		<ul class="slider_container simple-list" id="slider">
			<li class="slide"><img src="/image/slide_img_1.png"></li>
			<li class="slide"><img src="/image/slide_img_2.png"></li>	
		</ul>			
		<a href="#" id="prev"><i class="fa fa-caret-left fa-3x"></i></a>
		<a href="#" id="next"><i class="fa fa-caret-right fa-3x"></i></a>
	</div>
<%-- 상품리스트 --%>
<div id="contents">
	<h3>지금 가장 핫한 상품<i class="fa fa-chevron-right"></i></h3>
	<div class="best_list">
	<%--반복문으로 상품 리스트 출력 --%>
	<div class="item">
		<a href="#">
		<div class="img_box">
			<img src="/image/123.png">
		</div>
		<div class="txt_box">
		  <h4>[HBAF] 매일 색다른 </h4>    
          <p>15,000 원</p>
        </div>  
		</a>
	</div>
	<%--끝나는 위치 --%>
	</div>
	<h3>이 상품 어때요?</h3>
	<div class="another_list">
	<%--반복문으로 상품 리스트 출력 --%>
	<div class="item">
		<a href="#">
		<div class="img_box">
			<img src="/image/123.png">
		</div>
		<div class="txt_box">
		  <h4>name</h4>    
          <p>price</p>
        </div>  
		</a>
	</div>
	</div>
</div>
<%-- 푸터 파일 include --%>
<%@include file ="../layouts/footer.jsp" %>

