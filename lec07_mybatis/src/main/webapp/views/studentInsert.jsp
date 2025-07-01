<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/student/insert' />" method="post">
		이름: <input type="text" name="studentName"><br>
		나이: <input type="number" name="studentAge">
		<button>등록</button>		
	</form>
</body>
</html>