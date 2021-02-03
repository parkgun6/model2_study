package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.dao.mapper.MyBatisMaker;
import org.zerock.domain.Store;

public class StoreDAO {

	private final String namespace = "org.zerock.dao.mapper.StoreMapper";
	
	public List<Store> getList() {
		
		List<Store> result = null;
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			result = session.selectList(namespace+".getAll");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}