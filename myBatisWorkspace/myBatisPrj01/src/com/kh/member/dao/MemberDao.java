package com.kh.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.vo.MemberVo;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) {
		
		System.out.println("DAO ::: " + vo);
		
		return ss.insert("memberMapper.join", vo);
		
//		String sql = "INSERT INTO MEMBER(ID, PWD) VALUES (?, ?)";
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		try {
//			pstmt = ss.prepareStatement(sql);
//			
//			pstmt.setString(1, vo.getMemberId());
//			pstmt.setString(2, vo.getMemberPwd());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(pstmt);
//		}
//		return result;
		
	}

	public List<MemberVo> selectMemberListAll(SqlSession ss) {
		
		return ss.selectList("memberMapper.selectAll");
	}

}
