package myspring.di.strategy2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.dao.UserDao;
import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-bean-configuration2.xml")
public class UserXmlTest {
	@Autowired
	@Qualifier("userService")
	UserService service;
	
	@Autowired
	@Qualifier("userDao")
	UserDao dao;
	
	@Test
	void user() {
		System.out.println("get User List = " + service.getUserList());
		assertEquals("dooly", service.getUser(1).getUserId());
		
		System.out.println("read All = " + dao.readAll());
		assertEquals("dooly", dao.read(1).getUserId());
	}
}
