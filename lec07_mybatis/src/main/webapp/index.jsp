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
	<!-- 1. index.jsp에 목록조회 a태그 생성 -->
	<ol>
		<li><a href="<c:url value='/student/list' />">학생 목록 조회</a></li>
	</ol>
	
	<!-- 2. 목록조회 요청을 받는 Servlet(Controller) 생성 -->
	<!-- 3. Service에 정보 전달 -->
	<!-- 4. DAO에 데이터베이스 연결 요청 -->
	<!-- 5. DAO에 Mapper에 있는 쿼리 실행 -->
</body>
</html>