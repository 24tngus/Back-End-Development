package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	public static void main(String[] args) {
		final String driver = "org.mariadb.jdbc.Driver";
		final String DB_IP = "localhost";
		final String DB_PORT = "3306";
		final String DB_NAME = "boot_db";
		final String DB_URL = 
				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. Driver class Loading
			Class.forName(driver);
			System.out.println("DB_URL = " + DB_URL);
			// 2. DB와 연결을 담당하는 Connection 객체 생성 
			conn = DriverManager.getConnection(DB_URL, "boot", "boot");
			System.out.println("Connection className = " + conn.getClass().getName()); 
			// Connection className = org.mariadb.jdbc.MariaDbConnection
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) { // class 예외 처리
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) { // getConnection 예외 처리 
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}

		try {
			String sql = "select * from customer";

			// 3. SQL문을 DB에게 전달해주는 역할을 하는 Statement 생성 
			pstmt = conn.prepareStatement(sql);
			System.out.println("Statement Class Name = " + pstmt.getClass().getName());
			
			// 4. SQL문 실행결과를 담는 역할을 하는 ResultSet 생성
			rs = pstmt.executeQuery();
			System.out.println("ResultSet Class Name = " + rs.getClass().getName());
			
			int id = 0;
			String name = null;
			String email = null;
			int age = 0;
			String entryDate = null;
			
			while (rs.next()) { 
				// getString : 해당 컬럼의 값 가져오기 
				id = rs.getInt("id");
				name = rs.getString("name");
				email = rs.getString("email");
				age = rs.getInt("age");
				entryDate = rs.getString("entryDate");
				
				System.out.print(id + " ");
				System.out.print(name + " ");
				
				System.out.println();
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}