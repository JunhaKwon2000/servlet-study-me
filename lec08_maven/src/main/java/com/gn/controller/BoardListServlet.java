package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Board;
import com.gn.dto.Member;
import com.gn.service.BoardService;
import com.gn.service.MemberService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	private MemberService memberService = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			response.sendRedirect(request.getContentType() + "/");
			return;
		} else {
			if (session.getAttribute("loginMember") == null) {
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}
		}
		
		// 게시글 목록 조회
		List<Board> boardList = service.selectBoardList();
		List<Member> memberList = memberService.selectAll();
		
		
		for (Board b : boardList) {
			for (Member m : memberList) {
				if (b.getBoardWriter() == m.getMemberNo()) {
					b.setMemberTrueId(m.getMemberId());
				}
			}
		}
		
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
