<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
    <meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/real_main.css.css"/>
    <link rel="stylesheet" type="text/css" href="css/mylist.css"/>

  
</head>
<body>

<h1 class="logo">
<a href="/">
<div style="text-align : center;">
<img src="/image/logo.png"  width="100" height="150" align="middle"  ><figcaption>홈으로</figcaption></a>
</h1>


<!--  
					<h1 class="logo">
					<a href="/"><img src="/image/logo.png" width="200" height="150"></a>
				</h1>
			-->	

<div class="container">
    
    <div class="section_login">
        <h3 class="tit_login">아이디 찾기</h3>
        <div class="write_form">
            <div class="write_view_login_view">

                <form method="get" action="/member/find/id">
                    <input type="text" name="name" size="20" tabindex="1" placeholder="이름을 입력해주세요">
                    <input type="text" name="email" size="20" tabindex="2" placeholder="이메일을 입력해주세요">
                    <div class="checkbox_save">
                        <div class="login_search">
                            <a class="link" href="./loginFind.html">
                                아이디 찾기
                            </a>
                            <span class="bar"></span>
                            <a class="link" onclick="KurlyTrackerLink('/member/find/password', 'select_find_password')" href="./passwordFind.html">
                                비밀번호 찾기
                            </a>
                        </div>
                    </div>
                  
                    <button class="btn_type1" type="submit">
                        <span class="txt_type">아이디 찾기</span>
                    </button>
                </form>

            </div>
        </div>
    </div>
    <br><br><br><br><br><br><br><br><br><br>
    
    </div>
    </body>
    
</html>