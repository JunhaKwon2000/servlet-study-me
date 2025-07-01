package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/stduent/detail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 여기여기여기
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 학생의 번호를 파라미터로 전달받음(파싱할 때 NPE 발생할 수 있으니 상황 봐가면서 해줘)
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 2. DB 조회
		Student student = service.getStudentDetail(no);
		
		// 3. 조회한 값 확인
		System.out.println(student);
		
		// 4. 하던거 하기
		request.setAttribute("student", student);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/studentDetail.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
