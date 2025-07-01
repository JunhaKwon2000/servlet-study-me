package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 단에서 전달받은 정보 가져오기
		int studentNo = Integer.parseInt(request.getParameter("no"));
		
		Student student = service.getStudentDetail(studentNo);
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("/views/studentUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentName = request.getParameter("studentName");
		int studentAge = Integer.parseInt(request.getParameter("studentAge"));
		
		// service의 updateStudent -> return 은 int
		// 이 return 값이 0보다 크면 목록 화면으로 redirect
		
		// 이 return 값이 0보다 작으면 수정 화면으로 redirect(쿼리 스트링 무조건 필요!!!!!!!! 왜냐면은 그 내가 원래 /student/update?no=${ student.studentNo } 여기 url에서 작업했기 떄문에
		// 아무런 변경 사항이 없으면 계속 그 화면을 띄워줘야 하는 것!)
		// 이 url은 한번 gpt에게 물어봐서 확실히 짚고 넘어가자!
		
		int result = service.updateStudent(studentNo, studentName, studentAge);
		
		if (result > 0) response.sendRedirect("/student/list");
		else response.sendRedirect("/student/update?no=" + studentNo);
		
	}

}
