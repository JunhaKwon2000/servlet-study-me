package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONObject;

import com.gn.dto.Attach;
import com.gn.dto.Board;
import com.gn.dto.Member;
import com.gn.service.AttachService;
import com.gn.service.BoardService;
import com.gn.service.MemberService;

/**
 * Servlet implementation class BoardWriteServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 20
)
@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/board/write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 게시글 정보 추출(글자)
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		int boardWriter = Integer.parseInt(request.getParameter("boardWriter"));
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardWriter(boardWriter);
		
		
		// 2. 파일 정보 추출(파일)
		File uploadDir = AttachService.getUploadDirectory();
		Attach attach = AttachService.handleUploadFile(request, uploadDir);
		
		
		// 3. 게시글과 파일 정보 데이터베이스에 추가
		int result = boardService.createBoardWithAttach(board, attach);
		
		JSONObject obj = new JSONObject();
		
		if (result > 0) {
			obj.put("res_code", "200");
			obj.put("res_msg", "게시글 등록이 성공적으로 진행되었습니다.");			
		} else {			
			obj.put("res_code", "500");
			obj.put("res_msg", "게시글 등록 중 오류가 발생했습니다.");			
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

}
