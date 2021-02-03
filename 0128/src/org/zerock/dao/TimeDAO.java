package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.dao.mapper.MyBatisMaker;

public class TimeDAO {

	private final String namespace = "org.zerock.dao.mapper.TimeMapper";
	
	public String getNow() {
		
		String result = "";
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			result = session.selectOne(namespace+".getTime");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
