package myspring.di.strategy1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;

public class UserXmlTest {

	@Test
	void user() {
		BeanFactory factory = new GenericXmlApplicationContext("classpath:spring-bean-configuration.xml");
		UserService service = factory.getBean("userService", UserService.class);
		
		System.out.println("get User List = " + service.getUserList());
		assertEquals("dooly", service.getUser(1).getUserId());
		
		UserDao dao = factory.getBean("userDao", UserDao.class);
		
		System.out.println("read All = " + dao.readAll());
		assertEquals("dooly", dao.read(1).getUserId());
	}
}
