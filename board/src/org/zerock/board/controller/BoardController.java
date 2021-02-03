package org.zerock.board.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.board.dao.BoardDAO;
import org.zerock.board.domain.Board;
import org.zerock.common.controller.MultiController;
import org.zerock.common.util.PageInfo;
import org.zerock.common.util.PageMaker;

import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/board/*")
public class BoardController extends MultiController {
	private static final long serialVersionUID = 1L;

	BoardDAO dao = new BoardDAO();
	
	public String listGET(HttpServletRequest req, 
			HttpServletResponse res) throws Exception {

		log.info("list........................");
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(getInt(req,"page",1));
		pageInfo.setPerSheet(getInt(req,"perSheet",10));
		
		int total = dao.getTotal();
		
		PageMaker pageMaker = new PageMaker(pageInfo, total);
		
		List<Board> list = dao.getList(pageInfo);
		
		list.forEach(board -> log.info(board));
		
		req.setAttribute("list", list);
		req.setAttribute("pageMaker", pageMaker);
		
		return "board/list";
	}

}
