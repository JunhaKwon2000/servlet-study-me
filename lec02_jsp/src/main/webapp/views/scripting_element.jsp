<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting</title>
</head>
<body>
	<%-- Sciptlet: 일반적인 자바 코드(이건 JSP 주석, 개발자 도구로도 안보임) --%>
	<% 
		int sum = 0;
		for (int i = 1; i <= 10; i++) sum += i;
		// out -> jsp의 내장객체, 실제 화면에 뭔가를 출력하고 싶을때
		out.println("총합: " + sum); // 이렇게 하면 그냥 아무 태그 없이 html에 그냥 쓰는 거랑 똑같음, 근데 이렇게 할거면 Servlet에 html 코드 쓰는거랑 뭐가 달라?
		// 글래서 expression tag 사용 -> %= 이렇게 되어있음, 세미콜론 절대 금지, out.prinln(;)을 대신하는 것, 출력만 함(제어문 X, ?는 가능)
	%>
	<br>
	
	<%-- Expression: 화면에 출력 --%>
	<p>총합: <%= sum %></p>
	<p><%= "총합: " + sum %></p>
	<br>
	
	<%-- Declaration: 선언(컴파일될 때 딱 한번만 선언됨) --%>
	<%! int visitCount = 0; %> 
	<% 
		int tempCount = 0;
		visitCount++;
		tempCount++;
	%>
	<%-- 선언으로 선언하면 딱 한번만(컴파일 시점) 0으로 초기화되서 값이 계속 올라감 --%>
	<p>선언 태그 사용: <%= visitCount %></p>
	<%-- 스크립틀릿으로 선언하면 페이지가 로드될 때마다 0으로 초기화되서 값이 1에서 멈춤 --%>
	<p>스크립틀릿 태그 사용: <%= tempCount %></p>
	
</body>
</html>