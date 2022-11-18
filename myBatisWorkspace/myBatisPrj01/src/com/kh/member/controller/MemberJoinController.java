package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{

	//회원가입 화면 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String MemberId = req.getParameter("memberId");
		String MemberPwd = req.getParameter("memberPwd");
		//데이터 뭉치기
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(MemberId);
		vo.setMemberPwd(MemberPwd);
		
		
		
		//디비 다녀오기
		int joinMember = new MemberService().join(vo);
		
		/* resp.getWriter().write("<h1>실행결과 : " + joinMember + "</h1>"); */
		req.setAttribute("result", joinMember);
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		//문자열 내보내기
	}
}
