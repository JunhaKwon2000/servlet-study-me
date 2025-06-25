package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ChangePageServlet
 */
@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		int count = 0;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (!(c.getName().equals("visit_count"))) count++; 
			}
		}
		
		Cookie cookie;
		if (count == cookies.length) {
			cookie = new Cookie("visit_count", "1");
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			String temp = "";
			for (Cookie c : cookies) {
				if (c.getName().equals("visit_count")) {
					temp = (Integer.parseInt(c.getValue()) + 1) + "";
					cookie = new Cookie("visit_count", temp);
					cookie.setMaxAge(60 * 60);
					response.addCookie(cookie);
					break;
				}
			}
		}
		response.sendRedirect("/views/countPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
