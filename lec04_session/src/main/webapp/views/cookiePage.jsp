<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		String userNickname = "_____";
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("user_nickname")) {
					userNickname = c.getValue();
					break;
				}
			}
		}
	%>
	<h2>닉네임 조회</h2>
	<div>
		<h4>유저 닉네임: <%= userNickname %></h4>
	</div>
	<h2>닉네임 설정</h2>
	<form action="/saveNick" method="post">
		<label for="user_name">닉네임: </label>
		<input type="text" id="user_name" name="user_name">
		<button>닉네임 설정</button>
	</form>
	<h2>닉네임 삭제</h2>
	<form action="/deleteNick" method="post">
		<button>닉네임 삭제</button>
	</form>
</body>
</html>