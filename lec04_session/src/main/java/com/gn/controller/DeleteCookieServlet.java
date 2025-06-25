package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteCookieServlet
 */
@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 삭제하기
		// 1. 삭제하고 싶은 쿠키와 같은 key로 쿠키 생성해주기
		Cookie cookie = new Cookie("user_id", "");
		
		// 2. 유효시간 0으로 설정
		cookie.setMaxAge(0);
		
		// 3. 응답에 쿠키 추가하기 -> 그럼 쿠키가 바로 삭제됨
		response.addCookie(cookie);
		
		// 4. 새로운 요청(루트 패스)로 redirect 해주세요
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
