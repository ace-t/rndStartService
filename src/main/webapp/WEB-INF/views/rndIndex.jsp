<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
  <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page session="false" %>
    <title>Main Page · Right Now Develop!</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>

  <body>
  	<div class="container-fluid">
  		<div class="row-fluid">
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9">
    		</div>
    		<div class="span9" align="center">
    			<h1>RND- Right Now Develop!</h1>
    		</div>
    		<div class="span8" style="background:url(/resources/img/acet.png) no-repeat;background-size:60% 100%;height:80%;width:90%;background-position: center">
    		<div style="color:#777;font-size:16px;font-weight:bold;position:relative;left:68%;top:70px">ACE-T'S 검색엔진  
    		</div>
    		
    		<form name="searchForm" id="searchForm" method="get" action="/search/search.json">
	 			<div class="span9">
	 				<div class="span8 offset3">
	  					<input type="text" id="searchKeyword" name="searchKeyword" class="span12">
					</div>
					<button id="searchBtn" class="btn btn-warning"> 검색</button>
	 			</div>
 			</form>   	
 			<div class="span10" align=center>
 			   <p>
 			   	<button class="btn btn-mini btn-primary" type="button">개발자 박태하</button>
 			   	<button class="btn btn-mini btn-primary" type="button">개발하고 싶은..</button>
 			   	<button class="btn btn-mini btn-primary" type="button">당장 개발하자!</button>
 			   	<button class="btn btn-mini btn-primary" type="button">다음,카카오 합병</button>
 			   	<button class="btn btn-mini btn-primary" type="button">테크 회사..</button>
 			   </p>
    		</div>	
  		</div>
	</div>
 	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/searchScript/js/search.js"></script>
   </body>
</html>