<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키, 세션</title>
</head>
<body>
	<h1>쿠키!</h1>
	<ul>
		<li><a href="/makeCookie">쿠키 생성</a></li>
		<li><a href="/editCookie">쿠키 수정</a></li>
		<li><a href="/deleteCookie">쿠키 삭제</a></li>
		<li><a href="/practiceCookie">유저 닉네임 과제로 이동하기</a></li>
		<li><a href="/changePage">방문 횟수 추적하기 과제로 이동하기</a></li>
	</ul>
	<h2>현재 쿠키 값 확인</h2>
	<%
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		// request 는 내장 객체여서 Cookie 임포트 안해도 됨!
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
		
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("user_id")) {
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<p>user_id 쿠키값: <%= userId %></p>
	<%-- 물론 쿠키도 무조건 화면에 보이는데만 쓰는것이 아닌 일반 적인 자바 코드에서(특히 서블릿에서 어떤 동작 처리할 때) 사용 가능하다는 것을 알고 있어야함! --%>
	
	<h1>세션!</h1>
	<ol>
		<li><a href="/createSession">세션 생성</a></li>
		<li><a href="/updateSession">세션 수정</a></li>
		<li><a href="/removeSession">세션 삭제</a></li>
	</ol>
	
	<%
		String memberId = "세션 없음";
		if (session != null) {
			if (session.getAttribute("member_id") != null) {
				memberId = (String)session.getAttribute("member_id");
			}
		}
	%>
	<p>세션 정보: <%= memberId %></p>
</body>
</html>