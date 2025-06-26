package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class CreateSessionServlet
 */
@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 생성하기
		// 1. 세션 객체 생성: 매개변수 default = true(세션이 없을 때는 만들고, 이미 존재할 때는 그 세션 가져옴)
		HttpSession session = request.getSession();
		
		// 2. 세션 속성값 지정
		// 속성을 지정하기 전에 이런 것들을 확인하고 싶을 수 있음
		// (1) 새로운 세션인지 확인하고 싶을 때
		if(session.isNew()) {
			
		}
		// (2) 기존에 특정 key에 해당하는 값이 있는가
		if(session.getAttribute("member_id") == null) {
			
		}
		
		session.setAttribute("member_id", "user_01");
		session.setMaxInactiveInterval(60 * 30); // 보통 30분
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
