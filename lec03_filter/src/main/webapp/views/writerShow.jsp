<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>익명 작성자</h1>
	<h4>작성자 정보: <%= request.getAttribute("writer") %></h4>
</body>
</html>