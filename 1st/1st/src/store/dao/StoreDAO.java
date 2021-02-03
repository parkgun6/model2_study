package store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.dao.MyBatisMaker;
import store.domain.Store;

public class StoreDAO {

	private static final String NAMESPACE = "store.dao.StoreMapper";

	public List<Store> getAll() {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getAll");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Store getOne(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getOne", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Store store) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE+ ".insert",store);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Long sno) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession(false)) {
			
//			session.delete(NAMESPACE+".deleteReview",sno);
			
			session.delete(NAMESPACE+ ".delete",sno);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Store store) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE+ ".update",store);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
