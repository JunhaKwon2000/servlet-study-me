<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>캘린더</title>
	<!-- FullCalendar Library -->
	<link href='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.17/main.min.css' rel='stylesheet' />
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.17/index.global.min.js"></script>
 	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.17/locales-all.min.js'></script>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<!-- My JavaScript -->
	<script src="main.js"></script>
	<!-- My CSS -->
	<link href='main.css' rel='stylesheet' />
</head>
<body>
	<h1>캘린더 페이지 데모</h1>
	<div id="calendar"></div>
	
	<!-- 도움이 되는 웹사이트 -->
	<!-- FullCalendar Site: https://fullcalendar.io/ -->
	<!-- FullCalendar 사용 예시: https://nowonbun.tistory.com/368 -->
	
	<h1>로그인 연습</h1>
	<%
		boolean flag = false;
		if (session != null) {
			if (session.getAttribute("loginAccount") != null) {
				flag = true;
			}
		}
	%>
	<div id="login">
	<% if (!flag) { %>
		<form action="/login" method="post">
			<label>아이디 : </label>
			<input type="text" name="id"><br>
			<label>비밀번호 : </label>
			<input type="password" name="pw">
			<button>로그인</button>
		</form>
	<% } else { %>
		<p>관리자님 환영합니다!<p>
		<a href="/logout">로그아웃</a>
	<% } %>	
	</div>
	
	<h1>쿠키 연습1</h1>
	<%
		String nickname = "_____";
	
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("nickname".equals(cookie.getName())) {
					nickname = cookie.getValue();
				}
			}
		}
	%>
	<div id="cookie_practice1">
		<form action="/save_nickname" method="post">
			<label for="nickname">아이디: </label>
			<input type="text" name="nickname" id="nickname">
			<button>설정</button>
		</form>
		<a href="/delete_nickname">삭제</a>
		<div><%= nickname %></div>
	</div>
	<div id="cookie_practice2">
		<a href="/cookie_page">쿠키 페이지로 이동하기</a>
	</div>
	
	<h1>비동기 통신(ajax + json) 방명록 연습</h1>
	<a href="/guestBook">방명록으로 이동하기</a>
</body>
</html>