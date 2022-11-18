package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/insert")
public class BoardInsertController extends HttpServlet{
	//게시글 작성하기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	//게시글 작성하기 jjin
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardService bs = new BoardService();
		
		int result = bs.write(vo);
		
		if(result == 1) {
			//성공
			//req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			resp.sendRedirect("/mb02/board/list");
		}else {
			//실패
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
}
