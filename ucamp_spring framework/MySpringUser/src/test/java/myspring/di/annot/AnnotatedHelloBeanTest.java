package myspring.di.annot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// file:src/main/resources/spring-beans-annot.xml와 classpath:spring-beans-annot.xml 동일
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-annot.xml")
public class AnnotatedHelloBeanTest {
	// Hello가 종류가 1개밖에 없어서 Bean의 id와 일치하지 않아도 상관 없음 (type으로 찾기 때문에)
	@Autowired
	Hello hello;
	
	@Resource(name="stringPrinter")
	Printer printer;
	
	// Constructor Injection
	@Autowired
	HelloCons helloCons;
	
	@Test 
	public void helloCons() {
		Assertions.assertEquals("Hello annot생성자", helloCons.sayHello());
//		helloCons.print();
	}
	
	@Test @Disabled
	public void helloBean() {
		Assertions.assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		Assertions.assertEquals("Hello 어노테이션", printer.toString());
	}
}
