<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- page: 패키지 임포트 -> 그냥 하나씩 해도 되고, (,)로 연결해도 됨! --%>   
<%@page import="java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Tag</title>
</head>
<body>
	<% 
		List<String> list = new ArrayList<>();
		list.add("사과");
		list.add("바나나");
	%>
	<h2>과일 바구니 안에 들어있는 과일의 개수: <%= list.size() %>개</h2>
	<ul>
		<%-- 이렇게 쓰지 마세요! --%>
		<li><%= list.get(0) %></li>
		<li><%= list.get(1) %></li>
		<% 
			for(String s : list) {
				out.println("<li>" + s + "</li>");
			} 
		%>
	</ul>
	<ul>
		<%-- 이렇게 쓰세요! --%>
		<%-- 이러면 html 태그도 반복 가능!!! --%>
		<% for(String s : list) { %>
			<li><%= s %></li>
		<% } %>
	</ul>
</body>
</html>