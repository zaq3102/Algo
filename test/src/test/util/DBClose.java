package test.util;

import java.sql.*;

public class DBClose {

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void close(AutoCloseable...autoCloseables) {
//		for(AutoCloseable ac : autoCloseables) {
//			if(ac != null) {
//				try {
//					ac.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
}
