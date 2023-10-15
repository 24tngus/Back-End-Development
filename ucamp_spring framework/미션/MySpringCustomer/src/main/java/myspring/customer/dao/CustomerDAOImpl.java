package myspring.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVO;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<CustomerVO> selectAllCustomer() {
		return customerMapper.selectAllCustomer();
	}

	@Override
	public CustomerVO selectCustomer(int id) {
		return customerMapper.selectCustomer(id);
	}

}
