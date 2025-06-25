package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EditCookieServlet
 */
@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// user_id 라는 name 값을 가진 쿠키의 value를 admin으로 수정할거임
		// 기존과 동일한 유지 시간 설정
		// => index.jsp화면에서 <쿠키 수정> 클릭 후 새로고침
		
		Cookie cookie = new Cookie("user_id", "user02");
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
		
		// redirect 를 통해 루트 경로로 이동함 -> 진짜 완전히 새로운 요청임, 이전의 요청은 사라짐?
		// 브라우저가 새로운 요청을 다시 보내게(강제로, 개발자인 내가 컨트롤하는) 메서드: sendRedirect
		// 굉장히 강하기 때문에 이전에 request에 담아논 정보들이 모조리 날아감
		// 예를 들어 페이지를 넘어가면서 데이터를 유지시키려면 forward() 써야함
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
