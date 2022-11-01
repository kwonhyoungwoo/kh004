<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컬리 소개</title>
<%@include file="../layouts/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="css/main/siteInfo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="start_area">
		<h2 class="start_title">마켓컬리의 시작</h2>
		<p>
			이 세상에는 참 다양한 푸드마켓이 있습니다. 하지만 우리와 꼭 맞는 마음을 가진 푸드마켓을 찾기란 쉽지 않았습니다.
			‘그렇다면 우리가 직접 만들어보면 어떨까?’ 2015년 마켓컬리는 그렇게 시작되었습니다. <br> <br>

			맛있는 음식이 삶의 가장 큰 즐거움이라 믿는 사람들이 뜻을 합쳤죠. 컬리의 팀원들은 이미 팀을 꾸리기 전부터 좋은 재료를
			위해서라면 해외 직구, 백화점, 동네 마트, 재래 시장, 더 나아가 전국 방방곡곡의 산지를 찾아 다니며 품질과 가격을
			비교하던 깐깐한 소비자였습니다. 이렇게 찾아낸 훌륭한 생산자와 최상의 먹거리들을 나와 내 가족만 알고 있기에는 너무
			아쉬웠습니다. <br> <br> 비싼 식자재만이 좋은 음식일 것이라고 막연하게 생각하고 있는 소비자에게는
			진짜 맛을 소개해드리고 싶었고, 뚝심 하나로 산골 오지에서 수십 년간 묵묵히 장을 담그는 명인, 시들어서 버릴지언정 무농약을
			고집하는 농부에게는 안정적인 판매 활로를 찾아드리고 싶었습니다. 생산자와 소비자, 판매자까지 모두 행복하고 맛있는 삶을 살
			수 있도록 컬리는 오늘도 열심히 발로 뛰며 고민합니다.
		</p>
	</div>
	<div class="img_area">
		<img src="image/info_img.png">
	</div>
	<div class="start_area">
		<h2 class="start_title">컬리의 믿음, 그리고 지켜야 할 가치</h2>
		<p>
			시작은 단순했지만 고민은 깊었습니다. 직원이 아닌 한 사람의 고객으로서도 오래도록 사랑할 수 있는 서비스를 만들고자 했기에,
			상품을 검토할 때 ‘잘 팔릴까’ 보다는 ‘내가 사고 싶은지’를 먼저 물었고, ‘많이 팔릴지’ 보다는 ‘많이 팔려야
			마땅한지’를 고민했고, 단기적으로 이익을 추구하기보다는 장기적으로 생산자와 소비자 모두에게 옳은 일을 하기 위해 치열하게
			고민하고 노력해왔습니다. <br> <br> 그 과정에서 컬리가 꼭 지키고자 했던 가치들을 공유합니다. 이
			가치들은 지금까지 그래왔듯 앞으로도 컬리가 성장하는 과정에서 방향을 잃지 않도록 길을 밝혀주는 등대의 역할을 해줄 것이며,
			동시에 컬리의 파트너인 생산자, 소비자, 그리고 주주 여러분께 드리는 약속이기도 합니다.
		</p>
	</div>
	<div class="map_area">
		<div id="map"></div>
		<div class="map_text">
			<ul>
				<li>
					<div class="info_menu">
						<h4 class="map_title">물류 혁신을 통해 최상의 품질로 전해드립니다.</h4>

						<p>오늘 주문하면 내일 아침 도착하는 샛별배송은 물류의 혁신이 없었다면 불가능한 일이었죠. 샛별배송을 포함한
							Kurly Fresh Solution은 산지에서 식탁까지의 시간을 줄이고, 온도를 제어해 상품의 가치를 극대화합니다.
							좋은 상품을 가장 좋은 상태로 고객님께 전해드리는 것. 컬리가 배송 시간부터 포장재까지 물류의 모든 것을 혁신한
							이유이자, 컬리의 물류가 가지는 가치입니다.</p>
					</div>
				</li>
				<li>
					<div class="info_menu">
						<h4 class="map_title">지속 가능한 유통을 실현해 나갑니다.</h4>
						<p>좋은 먹거리는 깨끗한 환경에서, 좋은 상품은 생산자에게 합리적인 유통 구조에서 시작되기에 마켓컬리는 환경,
							상품, 사람의 선순환을 이루는 지속 가능한 유통을 고민합니다. 지속 가능한 상품 선정부터 생산자와의 동반 성장,
							친환경 포장재 개발, 사회에 대한 기여까지 장기적으로 소비자와 생산자 모두에게 옳은 일을 하기 위해 노력합니다.</p>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a93d18a7f606daa560fc6e524d0f462b"></script>
	<script type="text/javascript" src="/js/main/siteInfo.js"></script>
</body>
</html>
<%@include file="../layouts/footer.jsp"%>

