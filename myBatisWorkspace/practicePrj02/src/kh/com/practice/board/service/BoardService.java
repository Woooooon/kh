package kh.com.practice.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.com.practice.board.dao.BoardDao;
import kh.com.practice.board.vo.BoardVo;
import kh.com.practice.common.db.JDBCTemplate;

public class BoardService {

	public int write(BoardVo vo) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		int result = new BoardDao().write(ss, vo);
		
		if(result == 1 ) {
			ss.commit();
		}else{
			ss.rollback();
		}
		
		ss.close();
		
		return result;
	}
	
	public List<BoardVo> BoardList(Map<String, String> map) {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		List<BoardVo> voList = new BoardDao().BoardList(ss, map);
		
		ss.close();
		
		return voList;
	}
}
