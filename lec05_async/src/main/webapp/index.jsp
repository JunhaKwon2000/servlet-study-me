<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Async</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>1. 텍스트 데이터로 주고받기</h1>
	<h2>1.1. GET 방식</h2>
	<input type="text" name="user_id" id="user_id">
	<input type="button" value="아이디 길이 구하기" id="ajax_get_btn">
	<div id="ajax_get_display"></div>
	
	
	<script>
		$(document).ready(function() {
			
			$('#ajax_get_btn').on('click', () => {
				const userId = $('#user_id').val(); // input 값
				$.ajax({
					url: '/getTextAjax?userId=' + userId,
					type: 'get',
					success: (data) => {
						console.log(data);

						// 1. data = <p>아이디: junharoket(10글자)</p>
						// $('#display').html(data);
						
						// 2. data = "순수 문자 아이디: " + userId + "(" + length + ")"
						$('#ajax_get_display').html($('<h3>').text(data));
					},
					error: () => {
						alert('요청 실패');
					}
				});
			});
			
			
		});
	</script>
	
	<h2>1.2. POST 방식</h2>
	<button type="button" id="ajax_post_btn">아이디 길이 구하기(2)</button>
	<div id="ajax_post_display"></div>
	
	
	<script>
		$(document).ready(() => {
			
			$('#ajax_post_btn').on('click', () => {
				const userId = $('#user_id').val(); // input 값
				$.ajax({
					url: '/postTextAjax',
					type: 'post',
					data: {userId: userId},
					success: (data) => {
						console.log(data);
						$('#ajax_post_display').html($('<p>').text(data)); // 이어 붙이는 것은 append
					},
					error: () => {
						alert('요청 실패');
					}
				})
				
			})
			
			
			
			
		})
	</script>
</body>
</html>