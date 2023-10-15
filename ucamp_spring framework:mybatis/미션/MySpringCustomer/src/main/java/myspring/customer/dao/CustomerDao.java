package myspring.customer.dao;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerDao {
	public List<CustomerVO> readAll();
	public CustomerVO read(String id);
}
