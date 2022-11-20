package kh.com.practice.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.com.practice.board.vo.BoardVo;

public class BoardDao {

	public int write(SqlSession ss, BoardVo vo) {
		
		return ss.insert("boardMapper.write", vo);
	}
	
	public List<BoardVo> BoardList(SqlSession ss, Map<String, String> map) {
		
		return ss.selectList("boardMapper.List",map);
	}
}
