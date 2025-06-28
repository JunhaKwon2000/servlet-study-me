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
	
	<h2>[과제]총점과 평균</h2>
	<h3>성적 계산기</h3>
	
	<label for="kor">국어 : </label>
	<input type="number" id="kor"><br>
	
	<label for="eng">영어 : </label>
	<input type="number" id="eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>
	
	
	<script>
		$(document).ready(() => {
			
			$('#btnPost').on('click', () => {
				const korScore = $('#kor').val();
				const engScore = $('#eng').val();
				const mathScore = $('#math').val();
				
				$.ajax({
					url: '/postAvgScore',
					type: 'post',
					data: {
						korScore: korScore,
						engScore: engScore,
						mathScore: mathScore
					},
					success: (data) => {
						console.log(data);
						$('#resultArea').html($('<h4>').text(data));
					},
					error: () => {
						alert('요청 실패');
					}
					
				})
				
			})
			
		})
	</script>
	
	
	<h2>1.3. JSON + AJAX</h2>
	<input type="text" id="searchName">
	<button type="button" id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	
	<script>
		
	$(document).ready(() => {
		
		$('#json_get_btn').on('click', () => {
			// 1. 사용자 이름 정보 가져오기
			// 2. GET 방식(비동기) 요청
			// 3. Servlet에 Account List 목록에서 해당 이름이 존재하는지 확인하고 이름이 포함된 사람 목록을 전달받음
			// 4. 화면에 목록 형태로 출력함
			
			const keyword = $('#searchName').val();
			
			$.ajax({
				url: '/searchAccount?name=' + keyword,
				type: 'get',
				dataType: 'json',
				success: (data) => {
					
					console.log(data.data);
					console.log(data.data.length);
					
					if (data.data.length != 0) {
						
						for (const item of data.data) {
							const no = item.no;
							const name = item.name;
							$('#json_get_div').append('<p>번호: ' + no + ', 이름: ' + name);
						}
						
					}
					
				},
				error: () => {
						
				}
			});
		});
		
		
	});
	
	</script>
	
	<h2>도서 검색</h2>
	<label for="searchBook">도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>
	
	<script>
	
		$(document).ready(() => {
			
			
			$('#book_get_btn').on('click', () => {
				
				const keyword = $('#searchBook').val();
				console.log(keyword);
				
				$.ajax({
					url: '/searchBook?keyword=' + keyword,
					type: 'get',
					dataType: 'json',
					success: (data) => {
						console.log(data.result);
						console.log(data.result.length)
	
						if (data.result.length != 0) {
							console.log('yes');
						}
						
						if (data.result.length != 0) {
							for (const item of data.result) {
								const no = item.no;
								const name = item.name;
								const writer = item.writer;
								$('#book_get_div').html($('<p>').text('번호: ' + no + ', 이름: ' + name));
							}
						} else {
							$('#book_get_div').html($('<p>').text());
							window.alert('검색 결과가 없습니다.');
						}
					}
					
					
					
				})
							
				
			})
			
			
			
		})
	
	
	</script>
	
	<h2>카테고리별 상품 조회</h2>
	<select id="categorySelect">
		<option value="1">전자제품</option>
		<option value="2">생활용품</option>
		<option value="3">패션</option>
	</select>
	<button type="button" id="searchBtn">조회</button>
	<div id="productListArea"></div>
	
	
	<script>
	
	$(document).ready(() => {
		$('#categorySelect').change(() => {
			
			const categoryCode = $("#categorySelect option:selected").val();
			console.log(categoryCode);
			
			$.ajax({
				url: '/searchProduct',
				type: 'post',
				dataType: 'json',
				data: {
					code : categoryCode
				},
				success: (data) => {
					console.log(data);
					$('#productListArea').empty();
					if (data.result.length != 0) {
						for (const item of data.result) {
							const name = item.name;
							const price = item.price;
							$('#productListArea').append('<p>이름: ' + name + ', 가격: ' + price);
						}
					} else {						
						$('#productListArea').html("해당 카테고리의 상품이 없습니다.");
					}
				}
				
				
			})
			
			
		})
		
		
	})
	
	</script>
	
	<h2>[과제] 방명록 비동기 통신</h2>
	<a href="/guestBook">방명록 과제로 이동하기</a>
</body>
</html>