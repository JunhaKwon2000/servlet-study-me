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
	
	<form action="<c:url value='/student/search' />" method="get">
		<input type="text" name="student_name">
		<button>이름 기준 검색</button>
	</form>
	
	<br>
	
	<!-- 상품명과 카테고리를 기준 상품 검색 -->
	<form action="<c:url value='/product/search' />" method="get">
		<div>
			<label id="searchProduct">상품명</label>
		</div>
		<input type="text" name="productName" id="searchProduct">
		
		<div>
			<label id="searchCategory">카테고리</label>
		</div>
		<select name="productCategory" id="searchCategory">
			<option value="0">==== 선택 ====</option>
			<option value="1">전자제품</option>
			<option value="2">의류</option>
			<option value="3">식품</option>
		</select>
		
		<div>
			<div>
				<label id="sortPrice">정렬 기준</label>
			</div>
			<select name="sort" id="sortPrice">
				<option value="0">==== 선택 ====</option>
				<option value="1">가격이 낮은 순</option>
				<option value="2">가격이 높은 순</option>
			</select>
		</div>
		
		<div>
			<button>검색</button>
		</div>
	</form>
	
	
</body>
</html>