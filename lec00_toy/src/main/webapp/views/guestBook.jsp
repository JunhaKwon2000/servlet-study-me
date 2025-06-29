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
	<div id="guest_book">
		<div>
			<label for="name">이름</label>
		</div>
		<input type="text" name="name" id="name">
		<div>
			<label for="message">방명록</label>
		</div>
		<textarea rows="10" cols="20" id="message" name="message"></textarea>
		<div>
			<button id="submit">등록</button>
		</div>
		
		<br>
		
		<div id="posts"></div>
	</div>
	
	<script>
		$(document).ready(() => {
			
			$('#submit').on('click', () => {
				
				const name = $('#name').val();
				const message = $('#message').val();
				
				$.ajax({
					
					url: '/submitGuestBook',
					type: 'post',
					data: {
						name: name,
						message: message
					},
					dataType: 'json',
					success: (data) => {
						console.log(data);
						
						if (data.name !== '' && data.message !== '') {
							$('#posts').append('<div>작성자: ' + data.name);
							$('#posts').append('<div>방명록: ' + data.message);
							$('#posts').append('<div>등록일: ' + data.date);
							$('#posts').append('<br>');							
						} else {
							window.alert('필수 데이터 부재');
						}
					},
					error: () => {
						window.alert('통신 에러')
					}
					
				})
				
				
			})
			
		})
	
	</script>
</body>
</html>