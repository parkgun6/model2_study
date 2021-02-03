package store.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.dao.MyBatisMaker;
import store.dao.StoreDAO;
import store.domain.Store;

public class StoreDAOTests {

	private StoreDAO dao;
	
	@Before
	public void ready() {
		dao = new StoreDAO();
	}
	
	@Test
	public void testSqlSessionFactory() {
		
		System.out.println(MyBatisMaker.INSTANCE.getFactory());
	}
	
	@Test
	public void testGetAll() {
		
		List<Store> stores = dao.getAll();
		
		System.out.println(stores);
		for (Store store : stores) {
			System.out.println(store);
		}
	}
	
	@Test
	public void testGetOne() {
		
		Store store = dao.getOne(124L);
		
		System.out.println(store);
	}
	
	@Test
	public void testInsert() {
		
		Store store = Store.builder()
				.name("우리집")
				.lat(123.123)
				.lng(123.123)
				.menu("백반")
				.build();
		
		dao.insert(store);
	}
	
	@Test
	public void testDelete() {
		
		Long sno = 74L;
		dao.delete(sno);
	}
	
	@Test
	public void testUpdate() {
		
		Store store = Store.builder()
				.sno(43L)
				.name("우리집")
				.lat(123.123)
				.lng(123.123)
				.menu("백반")
				.build();
		
		dao.update(store);
	}
}
