<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <style>

    .dropdown-menu {
      position: static !important;
      display: none;
      margin-top: 10px;
    }

    .dropdown-menu.show {
      display: block;
      transform: none !important;
    }

    .dropdown-item {
      text-align: center;
    }


  </style>
    
</head>
<body>
	<div class="container text-center">
  <div class="row">

    <div class="">
      <ul class="nav flex-column">



     <li class="nav-item">
          <a class="nav-link" href="/calendarView">캘린더</a>
        </li>
     

              <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">성적관리</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/scoreView">성적입력</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>

        <li class="nav-item">
          <a class="nav-link" href="#">좌석</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/calendarView">태블릿</a>
        </li>

             <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">공지사항</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/scoreView">질의응답</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>

        <li class="nav-item">
          <a class="nav-link" href="#">질의응답</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="#">마이페이지</a>
        </li>

      </ul>

    </div>
  </div>
</div>

</body>
</html>