package myspring.customer.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.customer.dao.CustomerDao;
import myspring.customer.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerdao;

	public List<CustomerVO> getCustomerList() {
		return customerdao.readAll();
	}

	@Override
	public CustomerVO getUser(String id) {
		return customerdao.read(id);
	}

}
