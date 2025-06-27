<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, java.util.List, com.gn.dto.Product"%>
<% List<Product> list = (List<Product>)request.getAttribute("product_list"); %>
<%
	List<Product> product = null;
	if(session != null){
		if(session.getAttribute("product") != null){
			product = (List<Product>)session.getAttribute("product");
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 목록 조회</h2>
	<form action="/addToCart" method="post">
	    <select name="product">
      		<option value="" selected>--- 선택해 주세요 ---</option>
      		<% for(Product items : list) { String code = items.getCode() + ""; %>
      			<option value=<%= code %>><%= items.getName() %></option>      			
      		<% } %>
    	</select>
    	<button>장바구니에 추가</button>
	</form>
	
	<h2>장바구니</h2>
	<% if (product == null) { %>
		<p>장바구니가 비어있습니다.</p>
	<% } else { for (Product p : product) {%>
		<p><%= p.toString() %></p>
	<% } } %>
</body>
</html>