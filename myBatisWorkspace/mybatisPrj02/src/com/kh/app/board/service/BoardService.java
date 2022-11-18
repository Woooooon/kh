package com.kh.app.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.SearchVo;
import com.kh.app.common.db.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		
		int result = dao.write(ss, vo);
		
		if(result == 1 ) {
			ss.commit();
		}else{
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	}

	public List<BoardVo> selectBoardList() {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		
		List<BoardVo> voList = dao.selectBoardList(ss);
		
		ss.close();
		
		return voList;
	}

	public List<BoardVo> searchBoardList(Map<String, String> map) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		BoardDao dao = new BoardDao();
		
		List<BoardVo> voList = dao.searchBoardList(ss, map);
		
		ss.close();
		
		return voList;
	}

}
