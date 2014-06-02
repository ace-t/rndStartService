<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>부트스트랩으로 만든 RND~!!!Page!!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 부트스트랩 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="resources/mainPage/css/mainPage.css"/>
    <script type="text/javascript">
    </script>
  </head>
  <body>
   <div id="div1"><h2>Right Now!! Develop!!!</h2></div>
    <div class="navbar">
       <div class="navbar-inner">
          <a class="brand" href="#">RND(Right Now! Develop!)</a>
          <ul class="nav">
            <li class="active"><a href="#">Home</a></li>
            <li id="notice"><a href="#">공지사항</a></li>
            <li id="fCome"><a href="#">처음오셨다면 클릭!!</a></li>
            <li><a href="#">Develop History</a></li>
            <li><a href="#">Issue 그리고 Error</a></li>
            <li id="studyDev"><a href="#">학습지 개발 for MAE</a></li>
          </ul>
      </div>
    </div>
    
    <form class="form-search" action="/search/searchResult.json">
      <center>
        <div class="input-append">
          <input type="text" id="searchInput" name="searchInput" class="span2 search-query">
          <button id="searchBtn" class="btn">검색</button>
        </div>
        </center>
      </form>

    <h4><center>  지금 당장 개발 하십시요! Just Don't Speak!!</center></h4>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
        <!--사이드바 내용-->
          <span class="label label-success">Step 01.</span>
          <p id="study"> 공부하라!</p>
          <span class="label label-warning">Step 02.</span>
          <p id="develop"> 실습(개발)과 병행하라!</p>
          <span class="label label-inverse">Step 03.</span>
          <p id="result"> 결과를 내라!!</p>
          <p id="facebookLink" style='display:none'>
             <a href="https://www.facebook.com/groups/1499035550325310/" target="blank">
                <img src="resources/mainPage/img/facebook.png" width="50" height="50" alt="페이스북 그룹 가입!"/> Join!!
             </a>
          </p>   
        </div>  
        
        
        <div class="span10">
        <!--본문 내용-->
        <div class="tabbable"> <!-- 왼쪽과 오른쪽 탭에만 필요 -->
          <ul class="nav nav-tabs">
            <li class="active"><a href="#tab1" data-toggle="tab">Intro</a></li>
            <li><a href="#tab2" data-toggle="tab">RND 소개</a></li>
          </ul>
          <div class="tab-content">
          	<div class="tab-pane active" id="tab1">
            	<div id="myCarousel" class="carousel slide">
		            <ol class="carousel-indicators">
		              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		              <li data-target="#myCarousel" data-slide-to="1"></li>
		              <li data-target="#myCarousel" data-slide-to="2"></li>
		            </ol>
            
		            <!-- 회전광고판 항목 -->
		            <div class="carousel-inner">
		            	<div id="img1" class="active item"><img src="resources/img/rnd.png"  class="img-rounded"></div>
			            <div id="img2" class="item"><img src="resources/img/rnd.png"  class="img-rounded"></div>
		              	<div id="img3" class="item"><img src="resources/img/rnd.png" class="img-rounded" id="attrTest"></div>
		            </div>
		            <!-- 회전광고판 탐색 -->
		            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
          		</div>
            </div>
            <div class="tab-pane" id="tab2">
              <p>현재..node.js공부중..</p>
            </div>
        </div>
      </div>

	  <div id="studyPanel" class="panel panel-default">
		<div class="panel-heading">
    		<h3 class="panel-title">Panel title</h3>
	  	</div>
	    <div class="panel-body">
	         Panel content
	     </div>
	 </div>
      
    </div>
   </div>
 </div>
    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/mainPage/js/mainPage.js"></script>
  </body>
</html>
