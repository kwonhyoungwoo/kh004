<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../layouts/header.jsp" %>
<link href="/css/main/list.css" rel="stylesheet" type="text/css">
<div id="contents">
    <c:if test="${search ne null and search ne ''}">
        <h3 class="search">'<span class="search bold-test">${search}</span>'에 대한 검색결과</h3>
    </c:if>


    <div class="container">
        <c:if test="${search eq null || search eq ''}">
            <ul class="list">
                <li class="list-li"><a class="list-a"  href="/item/${category}">전체보기</a></li>
                <c:forEach var="item" items="${secondList}">
                    <li class="list-li"><a class="list-a" href="/item/${category}?filter=${item.secondaryCategory}">${item.secondaryCategory}</a>
                    </li>
                </c:forEach>
            </ul>

        </c:if>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:forEach var="item" items="${itemList}">
                <div class="col i">
                    <a href="#">
                        <div class="img_box">
                            <img src="/image/123.png">
                                <%-- <img src="${item.product_photo}">--%>
                        </div>
                        <div class="txt_box">
                            <h4>${item.productName} </h4>
                            <p>${item.product_price}원</p>
                        </div>
                    </a>
                </div>

            </c:forEach>
        </div>
        <c:if test="${empty itemList}">
            <div class="search-box">
                <svg width="48" height="48" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_368_6766)">
                        <path d="M22.0732 43.1463C33.7116 43.1463 43.1463 33.7116 43.1463 22.0732C43.1463 10.4348 33.7116 1 22.0732 1C10.4348 1 1 10.4348 1 22.0732C1 33.7116 10.4348 43.1463 22.0732 43.1463Z"
                              stroke="#e2e2e2" stroke-width="2" stroke-linecap="round"></path>
                        <path d="M47.8293 47.8291L37.2927 37.2925" stroke="#e2e2e2" stroke-width="2"
                              stroke-linecap="round"></path>
                    </g>
                    <defs>
                        <clipPath id="clip0_368_6766">
                            <rect width="48" height="48" fill="#fff"></rect>
                        </clipPath>
                    </defs>
                </svg>
                <span class="no-search">검색된 상품이 없습니다.</span>
            </div>

        </c:if>

    </div>


</div>
<%-- 푸터 파일 include --%>
<%@include file="../layouts/footer.jsp" %>

