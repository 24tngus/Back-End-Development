package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVO;

public class CustomerDAO {
	private Connection connection;
	
	public CustomerDAO(String driverClass, String url, String username, String password) {		
		// 1. Driver class Loading (1번만 실행 필요)
		try {
			Class.forName(driverClass);
			
			// 2. DB와 연결을 담당하는 Connection 객체 생성 
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connectionClose() { // // connection은 close 필요 
		try {
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 목록 조회 
	public List<CustomerVO> getCustomerList() {
		PreparedStatement pStmt = null;
		List<CustomerVO> customerList = new ArrayList<>();
		
		String sql = "select * from customer order by id";

		try {
			pStmt = connection.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				CustomerVO customerVO = new CustomerVO(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getInt("age"),
						rs.getString("entryDate"));
				customerList.add(customerVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null) pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerList;
	}
}
