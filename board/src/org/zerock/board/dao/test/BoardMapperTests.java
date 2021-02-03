package org.zerock.board.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.zerock.board.dao.BoardDAO;
import org.zerock.board.domain.Board;
import org.zerock.common.util.PageInfo;
import org.zerock.common.util.PageMaker;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {

	private BoardDAO dao;
	private PageInfo pageInfo;
	private PageMaker pageMaker;

	@Before
	public void ready() {
		dao = new BoardDAO();
		pageInfo = new PageInfo();

	}

	@Test
	public void testPaging() {
		int total = 128;
		
		pageInfo.setPerSheet(20);
		pageMaker = new PageMaker(pageInfo, total);
		
		log.info(pageMaker);

	}

	@Test
	public void testGetAll() {

		List<Board> boards = dao.getAll();

		System.out.println(boards);
		for (Board board : boards) {
			log.info(board);
		}
	}

	@Test
	public void testGetPage() {

		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(1);
		pageInfo.setPerSheet(20);
		
		List<Board> list = dao.getList(pageInfo);

		list.forEach(board -> log.info(board));
	}

}
