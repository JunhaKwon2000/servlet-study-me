<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>별을 그리기</h1>
	<c:forEach var="i" begin="1" end="${ stars }">
		<c:forEach var="j" begin="1" end="${ i }">
			<span>⭐</span>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>