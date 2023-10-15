package myspring.customer.dao.mapper;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerMapper {
	CustomerVO selectCustomerById(String id);
	List<CustomerVO> selectCustomerList();
}
