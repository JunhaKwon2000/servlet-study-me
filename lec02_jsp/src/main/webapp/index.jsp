<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>
	<div>
		<h2>1. JSP Scripting Element</h2>
		<a href="views/scripting_element.jsp">스크립팅 요소 연습</a>
	</div>
	<div>
		<h2>2. Directive Tag (page)</h2>
		<!-- <a href="views/page_element.jsp">page 태그 연습</a> -->
		<%-- a 태그는 서블릿한테 요청을 보낼 때 무조건 GET 방식으로 보냄 --%>
		<a href="/pageView">page 태그 연습</a>
	</div>
	<div>
		<h2>3. Directive Tag (include)</h2>
		<a href="views/include_element.jsp">include 태그 연습</a>	
	</div>
	<div>
		<h2>4. 과제: 도서 대출 시스템</h2>
		<a href="/reserveView">대출하기</a>
	</div>
	<div>
		<h2>5. 과제: 피자 주문하기</h2>
		<a href="/pizzaOrder">주문하기</a>
	</div>
</body>
</html>