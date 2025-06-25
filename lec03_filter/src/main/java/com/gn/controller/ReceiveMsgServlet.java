package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ReceiveMsgServlet
 */
@WebServlet("/recieve/msg")
public class ReceiveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("==== 요청 확인 ====");
		String msg = request.getParameter("msg");
		System.out.println(msg);
		
		request.setAttribute("msg", msg); // 응답할 때의 attribute
		
		// 화면단 경로는 반드시 /로 시작 해주세요!!!!!!!!!(절대경로로 해줘야함 -> webapp 아래 있는 views)
		// 만약에 맨 앞에 / 없이 화면을 설정하게 되면 /recieve/viewes/msgShow.jsp를 찾음
		RequestDispatcher view = request.getRequestDispatcher("/views/msgShow.jsp");
		// = getServletContext().getRequestDispatcher("/views/msgShow.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
