<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page session="false" %>
    <title>검색 결과 · Right Now Develop!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- IE6~8에서 HTML5 태그를 지원하기위한 HTML5 shim -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

  </head>

  <body>
     검색 결과 페이지 입니다.
     ${searchKeyword}로 검색하셨습니다.
   
  
 		<script src="http://code.jquery.com/jquery-latest.js"></script>
    	<script src="resources/js/bootstrap.min.js"></script>
   </body>
</html>