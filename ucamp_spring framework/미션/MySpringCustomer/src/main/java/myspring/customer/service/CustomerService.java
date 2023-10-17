package myspring.customer.service;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerService {
	
	List<CustomerVO> getAllCustomerList();

	CustomerVO getCustomerInfo(int id);
}
