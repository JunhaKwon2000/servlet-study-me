<%@page import="com.gn.dto.Student"%>
<%@page import="java.util.List"%>
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
	<h2>학생 목록 조회</h2>
	<%
		List<Student> list = (List<Student>)request.getAttribute("students");
	%>
	<ul>
		<% for (Student s : list) { %>
			<li><%= s.getStudentName() %>(나이: <%= s.getStudentAge() %>)</li>
		<% } %>
	</ul>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<% for (Student s : list) { %>
				<tr>
					<td><%= s.getStudentNo() %></td>				
					<td><%= s.getStudentName() %></td>				
					<td><%= s.getStudentAge() %></td>				
				</tr>
			<% } %>
		</tbody>
	</table>
	
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${ students }">
				<tr onclick="location.href='/stduent/detail?no=${ s.studentNo }'">
					<td>${ s.studentNo }</td>				
					<td>${ s.studentName }</td>				
					<td>${ s.studentAge }</td>				
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	
	<a href="<c:url value='/student/insert' />">학생 집어 넣기</a>

</body>
</html>