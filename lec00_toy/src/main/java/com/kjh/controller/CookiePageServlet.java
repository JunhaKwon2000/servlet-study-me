package com.kjh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookiePageServlet
 */
@WebServlet("/cookie_page")
public class CookiePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		boolean flag = false;		
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("count".equals(c.getName())) {
					flag = true;
					break;
				}
			}			
		}
		
		Cookie cookie = null;
		
		if (!flag) {
			cookie = new Cookie("count", "1");
		} else {
			for (Cookie c : cookies) {
				if ("count".equals(c.getName())) {
					String value = (Integer.parseInt(c.getValue()) + 1) + "";
					cookie = new Cookie("count", value);
					break;
				}
			}
		}
		
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
		
		response.sendRedirect("/views/cookiePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
