package org.zerock.time.dao.tests;

import org.junit.Test;
import org.zerock.time.dao.TimeDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {

	private TimeDAO dao = new TimeDAO();


	@Test
	public void testTime() {
		
		log.info(dao.getTime());
		
	}
}