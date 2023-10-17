package dbConnect;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-bean-customer.xml")
public class DbConnectTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void dataSourceTest(){
		System.out.println(dataSource.getClass().getName());
	}

	@Test
	public void sqlSessionFactoryTest(){
		System.out.println(sqlSessionFactory.getClass().getName());
		System.out.println(sqlSessionFactory.getConfiguration());
	}
	
	@Test
	public void sqlSessionTest(){
		System.out.println(sqlSession.getClass().getName());
		List<CustomerVO> list = sqlSession.selectList("myspring.customer.dao.mapper.CustomerMapper.selectAllCustomer");
		System.out.println("sqlSessionTest : "+list);
	}
	
	@Test
	public void customerMapperTest(){
		List<CustomerVO> list = customerMapper.selectAllCustomer();
		System.out.println("customerMapperTest : "+list);
	}
	
	@Test
	public void customerServiceTest(){
		List<CustomerVO> list = customerService.getAllCustomerList();
		System.out.println("customerServiceTest : "+list);
	}
}
