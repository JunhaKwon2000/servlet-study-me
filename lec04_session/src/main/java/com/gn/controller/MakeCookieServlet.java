package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MakeCookieServlet
 */
@WebServlet("/makeCookie")
public class MakeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키 만들기
		// step1: 쿠키 객체 생성하기
		// 주의! key가 중복되면 value를 덮어쓰기 때문에 협업할 때는 내가 쓴 쿠키가 다른 사람이 만든 쿠키와 이름(key)과 같을 수 있으니까 꼭 확인하기!
		Cookie cookie = new Cookie("user_id", "user01");
		
		// step2: 쿠키 유지 시간을 설정하기(단위는 초(sec))
		// 안에 넣는 초는 앵간하면 * 로 연결하는 습관을 들이는 것이 좋음 계싼된 값을 넣는 것이 아니라
		cookie.setMaxAge(60 * 60 * 24); // 1일 동안 유지
		
		// 3. 응답에 쿠키 추가해서 이걸 브라우저(예를들면 크롬)에 전달하기
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
