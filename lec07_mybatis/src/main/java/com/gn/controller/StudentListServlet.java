package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 여기여기여기
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		<!-- 2. 목록조회 요청을 받는 Servlet(Controller) 생성 -->
		
//		<!-- 3. Service에 정보 전달 -->
		List<Student> list = service.getStudentList();
		
//		<!-- 4. DAO에 데이터베이스 연결 요청 -->
		
		
		
//		<!-- 5. DAO에 Mapper에 있는 쿼리 실행 -->
		
		// => 학생 정보 목록 조회 -> /views/studentList.jsp 로 보내는 것이 최종 목적
		request.setAttribute("students", list);
		System.out.println(list);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/studentList.jsp");
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
