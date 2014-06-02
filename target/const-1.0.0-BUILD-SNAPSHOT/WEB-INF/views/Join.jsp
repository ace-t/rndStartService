<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 부트스트랩 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript">
    </script>
<title>RND Join Page</title>
</head>
<body>
	<form:form modelAttribute="joinAttribute" method="GET" action="/join/insertDB.json">
	  <fieldset>
	    <legend>RND 사이트 가입!</legend><br>
	    <label>가입은 아이디(e-mail)과 비밀번호만 작성합니다.</label><br>
	    <form:input type="text" path="id" placeholder="아이디 입력!"/>
	    <select>
		  <option>@hanmail.net</option>
		  <option>@naver.com</option>
		  <option>@gmail.com</option>
		  <option>@kt.com</option>
		  <option>@shisegae.com</option>
		</select><br>
		<form:input type="password" path="password" placeholder="비밀번호 입력!"/><br>
	    <span class="help-block">RND 사이트 가입 결정! 감사합니다.</span><br>
	    <button type="submit" class="btn">제출</button>
	  </fieldset>
	</form:form>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>