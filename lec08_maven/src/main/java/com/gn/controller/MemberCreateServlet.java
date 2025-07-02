package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.gn.service.MemberService;

/**
 * Servlet implementation class MemberCreateServlet
 */
@WebServlet("/memberCreate")
public class MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPw");
		
		System.out.println(id + " " + pw);
		
		JSONObject obj = new JSONObject();
		
		int result = service.insertMember(id, pw);
		
		if (result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "회원 가입 성공.");			
		} else {
			obj.put("res_code", "500");
			obj.put("res_msg", "회원 가입 실패.");	
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

}
