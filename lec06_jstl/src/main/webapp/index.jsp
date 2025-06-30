<%@page import="com.gn.dto.Planet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.dto.Person" %>
<%@ page import="com.gn.dto.Planet" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
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
	
	<h1>4. EL 연산자</h1>
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
		${ str1 eq "피자" }
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
	
	<h1>5. JSTL Core</h1>
	<h2>변수 선언</h2>
	<!-- c:set 사용 특징 -->
	<!-- 1. 자료형 선언 X: 무조건 문자열 -->
	<!-- 2. 초기값이 반드시 필요함 -->
	<!-- 3. c:set 으로 지정한 값을 스크립틀릿에서 꺼내 쓸 수 없음(반대는 가능!) -->
	<c:set var="num3" value="25" scope="page"/>
	<c:set var="num4" value="20"/>
	<c:set var="plus" value="${ num3 + num4 }"/>
	
	<h2>변수 출력</h2>
	<c:set var="result" value="<b>안녕하세요!</b>"/>
	<c:out value="${ result }" />
	<c:out value="${ result }" escapeXml="false"/>
	
	<h2>조건문: if</h2>
	<c:if test="${ num3 le num4 }">
		<p>num3가 num4보다 작거나 같다.</p>
	</c:if>
	
	<h2>조건문: choose</h2>
	<c:choose>
		<c:when test="${ num3 gt 20 }">
			<p>${ num3 }은 20보다 큽니다.</p>
		</c:when>
		<c:when test="${num3 le 20 and num3 gt 10 }">
			<p>${ num3 }은 10보다 크고 20보다는 작거나 같습니다.</p>		
		</c:when>
		<c:otherwise>
			<p>${ num3 }은 10보다 작거나 같습니다.</p>				
		</c:otherwise>
	</c:choose>
	
	<h2>조건문 연습: 라이트/다크 모드</h2>
	<h3>사이트 테마 설정</h3>
	<form method="post" action="/setTheme">
	    <button type="submit" name="theme" value="dark">다크모드</button>
	    <button type="submit" name="theme" value="light">라이트모드</button>
	</form>
	
	<c:set var="dark" value="dark"/>
	<c:set var="light" value="light"/>
	<c:choose>
		<c:when test="${ theme eq dark }">
			<div style="background-color: #222; color: white; min-height: 100vh; padding: 2rem; text-align: center;">
			    <h2 style="font-size: 2rem;">🌙 다크모드가 적용되었습니다.</h2>
			    <p style="font-size: 1.2rem;">눈의 피로를 줄이고 차분한 분위기를 제공합니다.</p>
			</div>
		</c:when>
		<c:when test="${ theme eq light }">
			<div style="background-color: #f0f0f0; color: #222; min-height: 100vh; padding: 2rem; text-align: center;">
			    <h2 style="font-size: 2rem;">☀️ 라이트모드가 적용되었습니다.</h2>
			    <p style="font-size: 1.2rem;">밝고 선명한 화면을 제공합니다.</p>
			</div>
		</c:when>
	</c:choose>
	
	<h2>반복문: forEach</h2>
	<!-- 기본 for문 처럼 사용하기 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>반복 숫자: ${ i }</p>
	</c:forEach>
	
	<!-- 향상된 for문 처럼 사용하기 -->
	<%
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	<ul>
		<c:forEach var="color" items="${ colors }">
			<li style="color:${ color }">${ color }</li>
		</c:forEach>	
	</ul>
	
	<!-- varStatus 속성 -->
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p>
			숫자: ${ num }, 
			인덱스: ${ vs.index }, 
			카운트: ${ vs.count },
			첫번째?(조건 가능): ${ vs.first },
			마지막?(조건 가능): ${ vs.last }			 
		</p>
	</c:forEach>
	
	<!-- 이 프로젝트의 root path 부터 시작을 자동으로 해주는 코드(쓰는 것이 안전함) -->
	<script src="<%= request.getContextPath() %>/resources/jquery-3.7.1.js"></script>
	<a href="<%= request.getContextPath() %>/boardList">게시판</a>
	
	<script src="<c:url value='/resources/jquey-3.7.1.js' />"></script>
	<a href="<c:url value='/boardList' />">게시판</a>
	
	<!-- 파라미터 사용하기(쿼리스트링 -> ? 뒤에 key-value -->
	<!-- 근데 이거 말고 그냥 url 뒤에 붙는 것이 더 일반적?인듯 -->
	<c:url var="testUrl" value="/boardList">
		<c:param name="nowPage" value="1" />
	</c:url>
	<a href="${ testUrl }">게시판</a>
	
	<h1>JSTL Formatting Library</h1>
	<h2>숫자 정보 포맷팅</h2>
	<!-- 이 친구는 그냥 출력됨(아무 출력문도 안넣었는데) -->
	<fmt:formatNumber value="1234.567" type="number" /><br>
	<fmt:formatNumber value="0.875" type="percent" /><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##" /><br>
	<fmt:formatNumber value="1234.5" pattern="00000.00" />
	
	<h2>날짜 정보 포맷팅</h2>
	<c:set var="now" value="<%= new java.util.Date() %>" />
	<fmt:formatDate value="${ now }" type="date" /><br>
	<fmt:formatDate value="${ now }" pattern="yy-MM-dd HH:mm:ss" /><br>
	
	<h1>JSTL Function Library</h1>
	<c:set var="data" value="How are you? I'm fine" />
	<p><c:out value="${ data }" /></p>
	
	<p><c:out value="${ fn:toUpperCase(data) }" /></p>
	<p><c:out value="${ fn:replace(data, 'fine', 'apple') }" /></p>
	
	<h2>별을 그리는 과제</h2>
	<form action="/drawStars" method="get">
		<label for="stars">별의 개수: </label>
		<input type="number" name="stars" id="stars">
		<button>그리기</button>
	</form>
</body>
</html>