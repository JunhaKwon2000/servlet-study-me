package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BookReserveEndServlet
 */
@WebServlet("/reserveBook")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReserveEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		String book_name = request.getParameter("book_name");
		String book_name_final = "";

		int borrow_period = Integer.parseInt(request.getParameter("borrow_period"));
		int price = 0;
				
		if (book_name.equals("1")) {
			book_name_final = "자바 프로그래밍 입문";
			price = 1500;
		} else if (book_name.equals("2")) {
			book_name_final = "웹 개발의 기초";
			price = 1800;
		} else if (book_name.equals("3")) {
			book_name_final = "데이터베이스 시스템";
			price = 2000;
		}
		price += 500 * (borrow_period - 1);
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("borrow_period", borrow_period);

		request.setAttribute("book_name", book_name_final);
		request.setAttribute("price", price);

		RequestDispatcher view = request.getRequestDispatcher("views/book/confirm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
