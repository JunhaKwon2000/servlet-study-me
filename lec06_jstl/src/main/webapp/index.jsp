<%@page import="com.gn.dto.Planet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Person" %>
<%@ page import="com.gn.dto.Planet" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL</title>
</head>
<body>
	<h1>Hello World!</h1>
	<%
		pageContext.setAttribute("test", "페이지");
		request.setAttribute("test", "리퀘스트");
		session.setAttribute("test", "세션");
		application.setAttribute("test", "애플리케이션");
	%>
	
	<h2>(1) JSP 방식</h2>
	<p><%= pageContext.getAttribute("test") %></p>
	<p><%= request.getAttribute("test") %></p>
	<p><%= session.getAttribute("test") %></p>
	<p><%= application.getAttribute("test") %></p>
	
	<h2>(2) EL 방식</h2>
	<!-- 
		1. ~Scope로 끝나는 내장객체 사용 
		2. 만약 내장 객체 지정 없이 key만 사용 하면 가장 작은 범주부터 탐색함(pageContext > ... > application)
	-->
	<p>${ sessionScope.test }</p>
	<p>${ test }</p>
	
	<h1>2. EL로 객체 다루기</h1>
	<%
		Person person = new Person("김철수", 77);
		request.setAttribute("person", person);
	%>
	<h2>(1) 순수 JSP 방식</h2>
	<%
		Person p = (Person)request.getAttribute("person");
		String info = p.getName() + ", " + p.getAge() + "살";
	%>
	<p><%= info %></p>
	
	<h2>(2) EL 방식</h2>
	<!-- EL 방식으로 객체 정보를 꺼내는 경우: key값, 필드명으로 꺼내쓰면 된다(key.field) -->
	<!-- 근데 주의! private 필드를 직접 꺼내는 것이 아닌 getter를 쓰는 것!!!! 꼭 getter가 있어야함 -->
	<p>${ person.name }, ${ person.age }</p>
	
	<h2>3. 연습 문제</h2>
	<%
		Planet planet = new Planet("지구", 1.5, true);
		request.setAttribute("planet", planet);
	%>
	<p>이름 : ${ planet.name }</p>
	<p>거리 : ${ planet.distance }억 km</p>
	<p>거주 가능 여부 : ${ planet.travel ? "O" : "X" }</p>
	
	<h1>s4. EL 연산자</h1>
	<%
		request.setAttribute("num1", 7);
		request.setAttribute("num2", 2);
		request.setAttribute("str1", "햄버거");
		request.setAttribute("str2", "피자");
		
		List<String> menu = new ArrayList<>();
		menu.add("짜장면");
		menu.add("짬뽕");
		request.setAttribute("menuList", menu);
	%>
	<p>
		${ num1 + num2 }
		${ num1 - num2 }
		${ num1 * num2 }
		${ num1 div num2 }
		${ num1 mod num2 }
	</p>
	<p>
		문자열 더하기
		${ str1 }${ str2 }
		${ str1 eq str2 }
		${ str1 ne str2 }
	</p>
	<p>
		${ empty menuList ? "메뉴가 비어있어요" : "메뉴가 있어요" }
		${ not empty menuList ? "메뉴가 비어있어요" : "메뉴가 있어요" }
	</p>
	<p>
		대소 비교 & 논리 연산
		${ num1 gt num2 } 
		${ num1 lt num2 } 
		${ num1 ge num2 } 
		${ num1 le num2 }
		
		num1이 num2보다 크고, menuList가 비어있지 않을 경우
		${ num1 gt num2 and not empty menuList } 
	</p>
		<%
	    request.setAttribute("kor", 85);
	    request.setAttribute("eng", 90);
	    request.setAttribute("math", 78);
	    request.setAttribute("name1", "이순신");
	    request.setAttribute("name2", "김유신");
	
	    List<String> heroList = new ArrayList<>();
	    heroList.add("홍길동");
	    request.setAttribute("heroList", heroList);
	%>
	<%-- 1. 산술 연산
		(1) 국어, 영어, 수학 점수 평균 => 나누기
		(2) 평균 점수가 80점 초과 => "합격" 그렇지 않으면 "불합격"
		
		2. 문자열 연결
		(1) 이순신김유신 처럼 이름 연결
		(2) 두분의 이름이 동일한지 비교 => "동일 인물" 그렇지 않으면 "다르다"
		
		3. 리스트 비어있는가
		(1) heroList가 비어있는지 판단 -> "O" 그렇지 않으면 "X"
		(2) 국어 점수가 영어 점수보다 높거나 heroList가 비어 있지 않은 경우 true 출력
		(3) 수학 점수가 80점 미만 이고, 영어 점수가 90점 이상이면 true 출력 --%>
	<h5>1. 산술연산</h5>
	<p>(1) ${ (kor + eng + math) div 3 }</p>
	<p>(2) ${ ((kor + eng + math) div 3) gt 80 ? "합격" : "불합격"}</p>
	<h5>2. 문자열 연결</h5>
	<p>(1) ${ name1 }${ name2 }</p>
	<p>(2) ${ name1 eq name2 ? "동일 인물" : "다르다" }</p>
	<h5>3. 리스트 비어있는가</h5>
	<p>(1) ${ empty heroList ? "O" : "X" }</p>
	<p>(2) ${ (kor gt eng) or (not empty heroList) ? "true" : "false" }</p>
	<p>(3) ${ (math lt 80) and (eng ge 90) ? "true" : "false" }</p>
	
	
</body>
</html>