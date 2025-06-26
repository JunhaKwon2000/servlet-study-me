package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PostAvgScoreServlet
 */
@WebServlet("/postAvgScore")
public class PostAvgScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAvgScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int korScore = Integer.parseInt(request.getParameter("korScore"));
		int engScore = Integer.parseInt(request.getParameter("engScore"));
		int mathScore = Integer.parseInt(request.getParameter("mathScore"));
		int sum = korScore + engScore + mathScore;
		Double average = sum / 3.0;
		String result = "";
		
		if (korScore >= 40 && engScore >= 40 && mathScore >= 40) {
			if (average >= 60.0) result = "[합격]축하드립니다, 합격입니다. 총점: " + sum + "점, 평균: " + average + "점";
			else result = "[불합격]평균이 60점 이하입니다. 총점: " + sum + "점, 평균: " + average + "점";
		} else result = "[불합격]과목들 중 점수가 40점 이하인 과목이 존재합니다. 총점: " + sum + "점, 평균: " + average + "점";
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
