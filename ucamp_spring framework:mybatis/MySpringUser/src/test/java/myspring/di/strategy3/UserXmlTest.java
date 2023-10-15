package myspring.di.strategy3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.strategy3.dao.UserDao;
import myspring.di.strategy3.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringBeanConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class UserXmlTest {
	@Autowired
	UserService service;
	
	@Autowired
	UserDao dao;
	
	@Test
	void user() {
		System.out.println("get User List = " + service.getUserList());
		assertEquals("dooly", service.getUser(1).getUserId());
		
		System.out.println("read All = " + dao.readAll());
		assertEquals("dooly", dao.read(1).getUserId());
	}

}
