<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page session="false" %>
    <title>검색 결과 · Right Now Develop!</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
       

  </head>

  <body>
  	<div class="container-fluid">
  		<div class="row-fluid">
    		<div class="span12">
      			<!--search bar-->
      			<div class="span9" align="center">
    				<h1>RND- Right Now Develop!</h1>
    			</div>
    			<div class="span8" style="background:url(/resources/img/acet.png) no-repeat;background-size:60% 100%;height:80%;width:90%;background-position: center">
    				<div style="color:#777;font-size:16px;font-weight:bold;position:relative;left:68%;top:70px">ACE-T'S 검색엔진  
    				</div>
    		
		    		<form name="searchForm" id="searchForm" method="get" action="/search.json">
			 			<div class="span9">
			 				<div class="span8 offset3">
			  					<input type="text" id="searchKeyword" name="searchKeyword" class="span12">
							</div>
							<button id="searchBtn" class="btn btn-warning"> 검색</button>
			 			</div>
		 			</form>   
    			</div>
			</div>
    		<div class="span12">
      		<!--search result-->
	      		<table  class="table table-striped">
				  <caption>ace-t's search engine based on Lucene!</caption>
				  <caption>검색어 <strong>${searchKeyword}</strong>로 검색하셨습니다.</caption>
				  <thead>
				    <tr>
				      <th>Name</th>
				      <th>Role</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${searchResults}" var="listValue">
				    <tr>
				      <td>${listValue.name}</td>
				      <td>${listValue.role}</td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>		
    		</div>
    	
    		<div class="span12">
      		<!--info-->
	      		<address>
				  	<strong>Ace-T, Inc.</strong><br>
				  795 Folsom Ave, Suite 600<br>
				  San Francisco, CA 94107<br>
				  <abbr title="Phone">P:</abbr> (010) 3835-xxxx
				</address>
				 
				<address>
				  <strong>Full Name</strong><br>
				  <a href="mailto:#">acetaeha@hanmail.net</a>
				</address>  
    		</div>
    	</div>	
    </div>	
  
   	<script src="http://code.jquery.com/jquery-latest.js"></script>
   	<script src="resources/js/bootstrap.min.js"></script>
   	<script src="resources/searchScript/js/search.js"></script>
</body>
</html>