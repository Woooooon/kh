package com.kh.member.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.member.dao.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {

	public int join(MemberVo vo) {
		//커넥션 준비
		//Connection conn = JDBCTemplate.getConnection();
		SqlSession ss = JDBCTemplate.getSqlSession();
		//sql 실행
		MemberDao dao = new MemberDao();
		int result = dao.join(ss, vo);
		//트랜잭션 처리 및 자원 반납
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		
			ss.close();
		//결과리턴
		return result;
	}

	public List<MemberVo> selectMemberListAll() {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		//sql실행
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.selectMemberListAll(ss);
		
		ss.close();
		
		return list;
	}

}
