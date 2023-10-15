package myspring.customer.sevice;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerService {
	public List<CustomerVO> getCustomerList();
	public CustomerVO getUser(String id);
}
