package org.zerock.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.zerock.dto.Review;

public class ReviewDAOTests {
	ReviewDAO dao;
	
	@Before
	public void ready() {
		dao = new ReviewDAO();
	}
	
	@Test
	public void checkSelect() throws Exception{
		List<Review> list =  dao.selectAll(12L);
		
		for(Review review : list){
			System.out.println(review);
		}
	}
	
}
