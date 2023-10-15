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
		// 1. Driver class Loading (1���� ���� �ʿ�)
		try {
			Class.forName(driverClass);
			
			// 2. DB�� ������ ����ϴ� Connection ��ü ���� 
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connectionClose() { // // connection�� close �ʿ� 
		try {
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ��� ��ȸ 
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
