<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h2>방명록</h2>
	<h4>이름</h4>
	<input type="text" id="name_input" >
	<h4>방명록 남기기</h4>
	<div>
		<textarea rows="5" cols="20" id="text_input"></textarea>
	</div>
	<button type="button" id="send_button">등록</button>
	<br>
	<ul id="text_area"></ul>
	
	<script>
	
	$(document).ready(() => {
		
		$('#send_button').on('click', () => {
			
			const name = $('#name_input').val();
			const msg = $('#text_input').val();
			
			$.ajax({
				
				url: '/postGuestBook',
				type: 'post',
				dataType: 'json',
				data: {
					name: name,
					msg: msg
				},
				success: (data) => {
					
					console.log(data);
					console.log(data.name);
					if (data.name !== "" && data.message !== "") {
						$('#text_area').append('<li>========================================</li>');						
						$('#text_area').append('<li>이름: ' + data.name + '</li>');
						$('#text_area').append('<li>방명록: ' + data.message + '</li>');
						$('#text_area').append('<li>작성일: ' + data.date + '</li>');
						$('#text_area').append('<li>========================================</li>');						
					} else {
						window.alert('필수 데이터 부재');
					}
					
					
					
					
					$('#name_input').val('');
					$('#text_input').val('');
					
					
				},
				error: () => {
					alert('등록 에러');
				}
				
			})
			
			
		})
	
	})
	
	</script>
</body>
</html>