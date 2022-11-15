document.addEventListener('DOMContentLoaded', function() {

	var $slideWrap = document.querySelector('.slide_area'),
		$slideContainer = document.querySelector('.slider_container'),
		$slide = document.querySelectorAll('.slide'),
		$navPrev = document.getElementById('prev'),
		$slideHeight = 0,
		$slideCount = $slide.length,
		$currentIndex = 0,
		$navNext = document.getElementById('next');

	//슬라이드 높이 확인 부모 높이 지정
	for (var i = 0; i < $slideCount; i++) {
		if ($slideHeight < $slide[i].offsetHeight) {
			$slideHeight = $slide[i].offsetHeight;
		}
	}

	$slideWrap.style.height = $slideHeight + 'px';
	$slideContainer.style.height = $slideHeight + 'px';

	//슬라이드 있으면 가로로 배열하기 
	for (var a = 0; a < $slideCount; a++) {
		$slide[0].style.left = a * 100 + '%';
	}

	//슬라이드 이동 함수
	function goToSlide(idx) {
		$slideContainer.style.left = -100 * idx + '%';
		$currentIndex = idx;
	}

	//다음, 이전버튼을 클릭하면 할일.
	$navPrev.addEventListener('click', function() {

		if ($currentIndex == 0) {
			goToSlide($slideCount - 1);
		} else {
			goToSlide($currentIndex - 1);
		}
	});

	$navNext.addEventListener('click', function() {

		if ($currentIndex == $slideCount - 1) {
			goToSlide(0);
		} else {
			goToSlide($currentIndex + 1);
		}

	});

	//자동 슬라이드
	setInterval(function() {
		var nextIdx = ($currentIndex + 1) % $slideCount;
		goToSlide(nextIdx);
	}, 4000);
});

/* 상품 슬라이드 */
$(function() {
	$('.item_wrap').slick({
		slidesToShow: 4,
		slidesToScroll: 4,
		infinite: false, //무한 슬라이드 
		speed: 300,
		nextArrow: $('.next'),
		prevArrow: $('.prev'),
	});
});

$(function() {
	$('.item_wrap2').slick({
		slidesToShow: 4,
		slidesToScroll: 4,
		infinite: false,
		speed: 300,
		nextArrow: $('.next2'),
		prevArrow: $('.prev2'),
	});
});

$(function() {
	$('.item_wrap3').slick({
		slidesToShow: 4,
		slidesToScroll: 4,
		infinite: false,
		speed: 300,
		nextArrow: $('.next3'),
		prevArrow: $('.prev3'),
	});
});