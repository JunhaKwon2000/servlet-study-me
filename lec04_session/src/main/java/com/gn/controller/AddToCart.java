package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int productCode = Integer.parseInt(request.getParameter("product"));

		Product product = null;

		if (productCode == 1001) product = new Product(1001, "키보드", 25000);
		else if (productCode == 1002) product = new Product(1002, "마우스", 15000);
		else if (productCode == 1003) product = new Product(1003, "모니터", 180000);
		
		
		List<Product> list = new ArrayList<>();
		HttpSession session = request.getSession();
		if (session.getAttribute("product") != null) {
			List<Product> productList = (List<Product>)session.getAttribute("product");
			System.out.println(productList);
			for (Product p : productList) {
				list.add(p);
			}
			list.add(product);
		} else {
			list.add(product);
		}
		
		session.setAttribute("product", list);
		session.setMaxInactiveInterval(60*30);
		
		response.sendRedirect("/productList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
