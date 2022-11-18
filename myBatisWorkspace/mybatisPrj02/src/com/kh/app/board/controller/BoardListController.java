package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	
	//게시글목록조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("category", category);
		
//		SearchVo vo = new SearchVo();
//		vo.setCategory(category);
//		vo.setKeyword(keyword);
		
		
		
		BoardService bs = new BoardService();
		List<BoardVo> voList = bs.searchBoardList(map);
		 
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
}
