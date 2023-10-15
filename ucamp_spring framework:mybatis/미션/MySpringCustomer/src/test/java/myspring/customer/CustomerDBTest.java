package myspring.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.sevice.CustomerService;
import myspring.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-customer.xml")
public class CustomerDBTest {
	@Autowired
	CustomerService customerService;
	
	@Test
	public void service() {
		CustomerVO customer = customerService.getUser("dooly");
		System.out.println(customer);
	}

}
