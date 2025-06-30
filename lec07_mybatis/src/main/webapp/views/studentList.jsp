<%@page import="com.gn.dto.Student"%>
<%@page import="java.util.List"%>
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
		List<Student> list = (List<Student>)request.getAttribute("students");
	%>
	<ul>
		<% for (Student s : list) { %>
			<li><%= s.getStudentName() %>(나이: <%= s.getStudentAge() %>)</li>
		<% } %>
	</ul>
</body>
</html>