package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVO;

public class CustomerDAO {

	private Connection conn;

	public CustomerDAO() {}
	public CustomerDAO(String driverClass, String dbUrl, String dbUserName, String dbUserPw) {
		try {
			Class.forName(driverClass);
			System.out.println("Driver Class 연결 완료");

			conn = DriverManager.getConnection(dbUrl, dbUserName, dbUserPw);
			System.out.println("DB에 접속 완료");

		} catch (ClassNotFoundException e) {
			if(driverClass==null||"".equals(driverClass.trim())){
				System.out.println("클래스 이름이 들어오지 않았습니다. web.xml설정을 확인해 주세요.");
			}else {
				System.out.println(driverClass+"에 해당되는 클래스가 없습니다. jar파일을 확인해 주세요.");
			}
		} catch (SQLException e) {
			System.out.println("DB에 연결 할 수 없습니다. url, id, pw를 확인해주세요.");
		}
	}

	public void connectionClosed() {
		if(conn!=null) {
			try {
				conn.close();
				System.out.println("DB에 접속 종료");

			} catch (SQLException e) {
				System.out.println("DB에 접속 종료 실패");
			}
		}
	}

    public List<CustomerVO> getAllCustomerList() {

        List<CustomerVO> customerList = new ArrayList<CustomerVO>();
        String sql = "SELECT * FROM CUSTOMER ORDER BY ID";

        PreparedStatement ps = null;

        try {
                   ps = conn.prepareStatement(sql);
                   ResultSet rs = ps.executeQuery();

                   while (rs.next()) {
                              int id = rs.getInt("id");
                              String email = rs.getString("email");
                              String name = rs.getString("name");
                              int age = rs.getInt("age");
                              Date entryDate = rs.getDate("entry_date");

                              CustomerVO customer = new CustomerVO(id, email, name, age, entryDate);
                              customerList.add(customer);
                   }

        } catch (SQLException e) {
                   System.out.println("조회에 오류가 발생했습니다");
        }finally {
        	if(ps!=null) {
    			try {
    				ps.close();
    			} catch (SQLException e) {
    			}
    		}
		}
        
        return customerList;

}


	
	
}
