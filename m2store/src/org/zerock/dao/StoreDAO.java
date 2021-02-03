package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.Store;

public class StoreDAO {
	
	private static final String driverName ="oracle.jdbc.driver.OracleDriver";
	private static final String jdbcURL= "jdbc:oracle:thin:@112.169.196.210:1521:XE";
	private static final String userName ="team10";
	private static final String userPW ="team10";

	public void insert(Store store)throws Exception{
		System.out.println("debug: insert " + store);
		
		//sql
		String sql = "INSERT INTO TBL_STORE (sno, name, lat, lng, menu) " +
		"values (seq_store.nextval,?,?,?,?) ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Class.forName(driverName);
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setDouble(2, store.getLat());
			pstmt.setDouble(3, store.getLng());
			pstmt.setString(4, store.getMenu());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
		
	}
	
	public List<Store> selectAll()throws Exception {

		List<Store> storeList = new ArrayList<>();
		
		String query ="SELECT * FROM TBL_STORE ORDER BY sno DESC";
		

		
		Class.forName(driverName);
		
		//sno,name,lat,lng,menu,
		//regdate, updatedate 

		try(Connection con = DriverManager.getConnection(jdbcURL,userName,userPW);
			PreparedStatement pstmt = con.prepareStatement(query);
				
			ResultSet rs = pstmt.executeQuery();
			){
			
			while(rs.next()) {
				Store store = new Store();
				store.setSno(rs.getLong(1));
				store.setName(rs.getString(2));
				store.setLat(rs.getDouble(3));
				store.setLng(rs.getDouble(4));
				store.setMenu(rs.getString(5));
				store.setRegdate(rs.getDate(6));
				store.setUpdateDate(rs.getDate(7));
				storeList.add(store);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return storeList;
	}

	public Store selectOne(Long sno)throws Exception {
		
		Store result = new Store();
		
		String query ="SELECT * FROM TBL_STORE WHERE sno = ?";

		
		Class.forName(driverName);
		
		//sno,name,lat,lng,menu,
		//regdate, updatedate 

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			con = DriverManager.getConnection(jdbcURL,userName,userPW);
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, sno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				


				result.setSno(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setLat(rs.getDouble(3));
				result.setLng(rs.getDouble(4));
				result.setMenu(rs.getString(5));
				result.setRegdate(rs.getDate(6));
				result.setUpdateDate(rs.getDate(7));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(rs != null) { try {rs.close(); }catch(Exception e) {} }
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
		
		return result;
	}

	public void delete(Long sno)throws Exception {
		
		System.out.println("debug: delete " + sno);
		
		//sql
		String sql = "delete from tbl_store where sno = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Class.forName(driverName);
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPW);
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, sno);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
	}
	
	public void update(Store store)throws Exception {
		String sql ="update tbl_store set name = ? , lat= ?, lng =?, menu =?, updatedate = sysdate where sno =?";
	
		Connection con = null;
		PreparedStatement pstmt = null;
		Class.forName(driverName);
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setDouble(2, store.getLat());
			pstmt.setDouble(3, store.getLng());
			pstmt.setString(4, store.getMenu());
			pstmt.setLong(5, store.getSno());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
	}
}







