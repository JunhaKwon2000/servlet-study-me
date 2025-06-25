package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PizzaOrderEndServlet
 */
@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		
		int pizzaSize = Integer.parseInt(request.getParameter("pizza_size"));
		String[] pizzaToppings = request.getParameterValues("pizza_toppings");
		String deliveryTime = request.getParameter("delivery_time");
		
//		System.out.println(userName);
//		System.out.println(userPhone);
//		System.out.println(userEmail);
//		
//		System.out.println(pizzaSize);
//		for (String s : pizzaToppings) System.out.println(s);
//		System.out.println(deliveryTime);
		
		request.setAttribute("user_name", userName);
		request.setAttribute("user_phone", userPhone);
		request.setAttribute("user_email", userEmail);
		request.setAttribute("delivery_time", deliveryTime);
		
		int price = 0;
		String size = "";
		switch (pizzaSize) {
			case 1: price = 15900; size = "Small"; break; 
			case 2: price = 21000; size = "Medium"; break; 
			case 3: price = 27900; size = "Large"; break;
		}
		request.setAttribute("pizza_size", size);
		
		if (pizzaToppings != null && pizzaToppings.length >= 1) {
			String[] toppingsInfo = new String[pizzaToppings.length];
			for (String toppings : pizzaToppings) {
				if (toppings.equals("1")) price += 2000;
				else price += 1000;
			}
			for (int i = 0; i < pizzaToppings.length; i++) {
				if (pizzaToppings[i].equals("1")) toppingsInfo[i] = "새우";
				else if (pizzaToppings[i].equals("2")) toppingsInfo[i] = "고구마";
				else if (pizzaToppings[i].equals("3")) toppingsInfo[i] = "감자";
				else if (pizzaToppings[i].equals("4")) toppingsInfo[i] = "파인애플";
			}
			request.setAttribute("pizza_toppings", toppingsInfo);
		}
		request.setAttribute("pizza_price", price);
		
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/result.jsp");
		view.forward(request, response);
		
	}

}
