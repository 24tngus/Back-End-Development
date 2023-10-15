package myspring.customer.dao.mapper;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerMapper {
	
	List<CustomerVO> selectAllCustomer();
	CustomerVO selectCustomer(int id);
	
}
