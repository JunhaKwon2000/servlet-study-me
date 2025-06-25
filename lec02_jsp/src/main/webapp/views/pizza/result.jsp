<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String[] toppings = (String[])request.getAttribute("pizza_toppings"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결과</title>
</head>
<body>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%= request.getAttribute("user_name") %></li>
		<li>전화번호 : <%= request.getAttribute("user_phone") %></li>
		<li>이메일 : <%= request.getAttribute("user_email") %></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>
			사이즈 : <%= request.getAttribute("pizza_size") %>
		</li>
		<li>
			토핑 : 
			<ul>
				<% if(toppings == null || toppings.length == 0) { %>
					<li>토핑 선택 안함</li>
				<% } else { %>
					<% for(String topping : toppings) { %>
						<li><%= topping %></li>
					<% } %>
				<% } %>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격 : <%= request.getAttribute("pizza_price") %>원</h3>
	<h4>즐거운 식사 시간되세요~</h4>
</body>
</html>