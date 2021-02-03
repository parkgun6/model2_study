package org.zerock.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.board.domain.Board;
import org.zerock.common.dao.MyBatisMaker;
import org.zerock.common.util.PageInfo;

public class BoardDAO {

	private static final String NAMESPACE = "org.zerock.board.dao.BoardMapper";

	
	public List<Board> getList(PageInfo pageInfo){
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getList",pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Board> getAll() {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectList(NAMESPACE + ".getAll");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getTotal() {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getTotal");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
