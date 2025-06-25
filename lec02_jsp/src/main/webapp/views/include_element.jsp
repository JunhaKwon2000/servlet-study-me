<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>==== Start ====</h2>
	<%-- 이거 경로 잘 생각해야돼 이 파일이 위치가 시작 경로야 --%>
	<%@ include file="scripting_element.jsp" %>
	<h2>==== End ====</h2>
	
	<%-- 이 계산이 가능함! 왜냐면 include 로 져온 파일에 sum 이라는 변수가 있기 때문! --%>
	<% int multiple = sum * 3; %>
	
	<p>계산 결과: <%= multiple %></p>
	
	<%-- 딱 보니 header, footer 등등 이런 공통적으로 쓸 수 있는 것들을 따로 빼서 만들어서 include 시키면 될 듯 ㅎㅎ --%>
</body>
</html>