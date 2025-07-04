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
		
		Board param = new Board();
		// 현재 페이지 정보 셋팅
		int nowPage = 1;
		String nowPageStr = request.getParameter("nowPage");
		if (nowPageStr != null) {
			nowPage = Integer.parseInt(nowPageStr);
		}
		param.setNowPage(nowPage);
		
		// 검색어 셋팅
		String keyword = request.getParameter("keyword");
		param.setKeyword(keyword);
		
		// 전체 게시글 개수 조회
		int totalData = service.selectBoardCount(param);
		param.setTotalData(totalData); // 여기서 시작과 끝점을 정해주고
		
		// 게시글 목록 조회
		List<Board> boardList = service.selectBoardList(param); // 여기서 그 목록의 페이지들을  
		
		request.setAttribute("paging", param);
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
