<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- ��Ʈ��Ʈ�� -->
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
	    <legend>RND ����Ʈ ����!</legend><br>
	    <label>������ ���̵�(e-mail)�� ��й�ȣ�� �ۼ��մϴ�.</label><br>
	    <form:input type="text" path="id" placeholder="���̵� �Է�!"/>
	    <select>
		  <option>@hanmail.net</option>
		  <option>@naver.com</option>
		  <option>@gmail.com</option>
		  <option>@kt.com</option>
		  <option>@shisegae.com</option>
		</select><br>
		<form:input type="password" path="password" placeholder="��й�ȣ �Է�!"/><br>
	    <span class="help-block">RND ����Ʈ ���� ����! �����մϴ�.</span><br>
	    <button type="submit" class="btn">����</button>
	  </fieldset>
	</form:form>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>