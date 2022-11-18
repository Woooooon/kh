package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.SearchVo;

public class BoardDao {

	public int write(SqlSession ss, BoardVo vo) {
		
		return ss.insert("boardMapper.write", vo);
	}
	
	//게시글 목록 조회
	public List<BoardVo> selectBoardList(SqlSession ss) {
		
		return ss.selectList("boardMapper.selectList");
	}
	
	public List<BoardVo> searchBoardList(SqlSession ss, Map<String, String> map) {
		
		return ss.selectList("boardMapper.searchList",map);
	}
	
}
