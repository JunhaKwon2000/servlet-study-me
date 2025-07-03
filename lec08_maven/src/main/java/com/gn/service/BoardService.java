package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	public List<Board> selectBoardList(){
		return boardDao.selectBoardList();
	}
	
	// 게시글과 파일 트랜잭션을 처리하는 메서드, 게시글 + 파일을 처리해야되기 때문에 insert 가 두개여서 트랜잭션으로 묶어야함
	public int createBoardWithAttach(Board board, Attach attach) {
		// 트랜잭션 처리라 여기서 DB 연결!(DAO 가 아니라)
		SqlSession session = SqlSessionTemplate.getSqlSession(false);
		
		int result = 0;
		try {
			// 게시글 등록
			// 진짜 쿼리는 DAO 담당
			result = boardDao.insertBoard(session, board);
			
			
			// 파일 정보 등록
			if (attach != null && result > 0) {
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session, attach);
			}
						
			// commit or rollback
			if (result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		
		
		return result;
	}

}
