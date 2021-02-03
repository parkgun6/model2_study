package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zerock.domain.Store;
import org.zerock.dto.Review;

public class ReviewDAO {

	private static final String driverName ="oracle.jdbc.driver.OracleDriver";
	private static final String jdbcURL= "jdbc:oracle:thin:@112.169.196.210:1521:XE";
	private static final String userName ="team10";
	private static final String userPW ="team10";

	public List<Review> selectAll(Long sno)throws Exception {

		List<Review> reviewList = new ArrayList<>();


		String query ="select R.rno, R.MID, R.text, R.score, R.REVIEWDATE, R.UPDATEDATE from tbl_store S, tbl_review R "
				+"where S.sno = R.sno and S.sno =? order by R.rno DESC";

		Class.forName(driverName);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = DriverManager.getConnection(jdbcURL,userName,userPW);
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, sno);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Review review = new Review();
				review.setSno(rs.getLong(1));
				review.setMid(rs.getString(2));
				review.setText(rs.getString(3));
				review.setScore(rs.getLong(4));
				review.setRegdate(rs.getDate(5));
				review.setUpdateDate(rs.getDate(6));
				reviewList.add(review);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(rs != null) { try {rs.close(); }catch(Exception e) {} }
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
		
		
		return reviewList;
	}


}
