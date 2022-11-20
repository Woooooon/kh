package kh.com.practice.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.com.practice.board.service.BoardService;
import kh.com.practice.board.vo.BoardVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("category", category);
		
		List<BoardVo> voList = new BoardService().BoardList(map);
		 
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
	
}
