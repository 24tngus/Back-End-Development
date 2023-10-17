package myspring.customer.dao;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerDAO {
	
	List<CustomerVO> selectAllCustomer();

	CustomerVO selectCustomer(int id);
	
}
