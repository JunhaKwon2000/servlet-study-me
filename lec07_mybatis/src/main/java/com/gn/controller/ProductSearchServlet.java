package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Product;
import com.gn.service.ProductService;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/product/search")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = new ProductService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 데이터 가져오기
		String productName = request.getParameter("productName");
		int productCategory = Integer.parseInt(request.getParameter("productCategory"));
		int sort = Integer.parseInt(request.getParameter("sort"));
		
		// service로 데이터 넘겨주기
		List<Product> list = service.searchProduct(productName, productCategory, sort);
		System.out.println(list);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
