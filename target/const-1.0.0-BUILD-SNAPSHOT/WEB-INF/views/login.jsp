<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>로그인 · Right Now Develop!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- 스타일 -->
    <link href="http://maczniak.github.io/bootstrap/assets/css/bootstrap-ko.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- IE6~8에서 HTML5 태그를 지원하기위한 HTML5 shim -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- 파비콘과 앱 아이콘 -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://maczniak.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://maczniak.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://maczniak.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="http://maczniak.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="http://maczniak.github.io/bootstrap/assets/ico/favicon.png">
  </head>

  <body>

    <div class="container">
    <button id="join">Join</button> 
      <form class="form-signin" id="loginRnd" method="post" action='/j_spring_security_check' >
        
        <h2 class="form-signin-heading">로그인하세요</h2>
        <input type="text" id="j_username" name='j_username' class="input-block-level" placeholder="이메일 주소">
        <input type="password" id="j_password" name='j_password' class="input-block-level" placeholder="암호">
       <!--  <label class="checkbox">
          <input type="checkbox" value="remember-me"> 로그인 유지
        </label>  -->
        <button id="loginBtn" class="btn btn-large btn-primary">로그인</button>
      </form>
      

    </div> <!-- /container -->

    <!-- 자바스크립트
    ================================================== -->
    <!-- 페이지를 빨리 읽어들이도록 문서 마지막에 배치 -->
    <script src="resources/loginPage/js/jquery.js"></script>
    <script src="resources/loginPage/js/bootstrap-transition.js"></script>
    <script src="resources/loginPage/js/bootstrap-alert.js"></script>
    <script src="resources/loginPage/js/bootstrap-modal.js"></script>
    <script src="resources/loginPage/js/bootstrap-dropdown.js"></script>
    <script src="resources/loginPage/js/bootstrap-scrollspy.js"></script>
    <script src="resources/loginPage/js/bootstrap-tab.js"></script>
    <script src="resources/loginPage/js/bootstrap-tooltip.js"></script>
    <script src="resources/loginPage/js/bootstrap-popover.js"></script>
    <script src="resources/loginPage/js/bootstrap-button.js"></script>
    <script src="resources/loginPage/js/bootstrap-collapse.js"></script>
    <script src="resources/loginPage/js/bootstrap-carousel.js"></script>
    <script src="resources/loginPage/js/bootstrap-typeahead.js"></script>
    <script src="resources/loginPage/js/loginPage.js"></script>

  

</body></html>