<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.gn.dto.Member" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="<c:url value='/resources/jquery-3.7.1.js' />"></script>    
</head>
<body>
	<h1>게시판</h1>
	<%@ include file="/views/include/nav.jsp" %>
	
	<form action="<c:url value='/boardList' />" method="get">
		<input type="text" name="keyword" placeholder="제목 또는 작성자" value="${ paging.keyword }">
		<button type="submit">검색</button>
	</form>
	
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${ boardList }">
				<tr onclick="location.href='<c:url value="/boardDetail?no=${ board.boardNo }" />'">
					<td>${ board.boardNo }</td>
					<td>${ board.boardTitle }</td>
					<td>${ board.memberTrueId }</td>
					<td>${ board.regDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${not empty boardList }">
		<div>
			<c:if test="${ paging.prev }">
				<a href="<c:url value='/boardList?nowPage=${paging.pageBarStart - 1}&keyword=${ paging.keyword }' />">
					&laquo;
				</a>
			</c:if>
			<c:forEach var="i" begin="${ paging.pageBarStart }" end="${ paging.pageBarEnd }">
				<a href="<c:url value='/boardList?nowPage=${ i }&keyword=${ paging.keyword }' />">
					${ i }
				</a>	
			</c:forEach>
			<c:if test="${ paging.next }">
				<a href="<c:url value='/boardList?nowPage=${paging.pageBarEnd + 1}&keyword=${ paging.keyword }' />">
					&raquo;
				</a>
			</c:if>
		</div>
	</c:if>
	<a href="<c:url value='/boardWrite' />">게시글 등록</a>
</body>
</html>