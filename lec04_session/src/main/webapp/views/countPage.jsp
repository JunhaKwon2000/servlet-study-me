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
		String count = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("visit_count")) {
					count = c.getValue();
					break;
				}
			}
		}
	%>
	<p> 당신은 이 페이지를
		<strong><%= count %></strong>번 방문했습니다.
	</p>
</body>
</html>