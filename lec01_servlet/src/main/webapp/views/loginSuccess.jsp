<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>환영합니다!</h1>
	<h2><%= request.getAttribute("id") %>님!</h2>
	<h2>비번: <%= request.getAttribute("pw") %></h2>
	<a href="/">홈페이지</a>
</body>
</html>