<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>��Ʈ��Ʈ������ ���� RND~!!!Page!!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- ��Ʈ��Ʈ�� -->
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
            <li id="notice"><a href="#">��������</a></li>
            <li id="fCome"><a href="#">ó�����̴ٸ� Ŭ��!!</a></li>
            <li><a href="#">Develop History</a></li>
            <li><a href="#">Issue �׸��� Error</a></li>
            <li id="studyDev"><a href="#">�н��� ���� for MAE</a></li>
          </ul>
      </div>
    </div>
    
    <form class="form-search" action="/search/searchResult.json">
      <center>
        <div class="input-append">
          <input type="text" id="searchInput" name="searchInput" class="span2 search-query">
          <button id="searchBtn" class="btn">�˻�</button>
        </div>
        </center>
      </form>

    <h4><center>  ���� ���� ���� �Ͻʽÿ�! Just Don't Speak!!</center></h4>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
        <!--���̵�� ����-->
          <span class="label label-success">Step 01.</span>
          <p id="study"> �����϶�!</p>
          <span class="label label-warning">Step 02.</span>
          <p id="develop"> �ǽ�(����)�� �����϶�!</p>
          <span class="label label-inverse">Step 03.</span>
          <p id="result"> ����� ����!!</p>
          <p id="facebookLink" style='display:none'>
             <a href="https://www.facebook.com/groups/1499035550325310/" target="blank">
                <img src="resources/mainPage/img/facebook.png" width="50" height="50" alt="���̽��� �׷� ����!"/> Join!!
             </a>
          </p>   
        </div>  
        
        
        <div class="span10">
        <!--���� ����-->
        <div class="tabbable"> <!-- ���ʰ� ������ �ǿ��� �ʿ� -->
          <ul class="nav nav-tabs">
            <li class="active"><a href="#tab1" data-toggle="tab">Intro</a></li>
            <li><a href="#tab2" data-toggle="tab">RND �Ұ�</a></li>
          </ul>
          <div class="tab-content">
          	<div class="tab-pane active" id="tab1">
            	<div id="myCarousel" class="carousel slide">
		            <ol class="carousel-indicators">
		              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		              <li data-target="#myCarousel" data-slide-to="1"></li>
		              <li data-target="#myCarousel" data-slide-to="2"></li>
		            </ol>
            
		            <!-- ȸ�������� �׸� -->
		            <div class="carousel-inner">
		            	<div id="img1" class="active item"><img src="resources/img/rnd.png"  class="img-rounded"></div>
			            <div id="img2" class="item"><img src="resources/img/rnd.png"  class="img-rounded"></div>
		              	<div id="img3" class="item"><img src="resources/img/rnd.png" class="img-rounded" id="attrTest"></div>
		            </div>
		            <!-- ȸ�������� Ž�� -->
		            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
          		</div>
            </div>
            <div class="tab-pane" id="tab2">
              <p>����..node.js������..</p>
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
