

package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*; // static 메서드를 테스트케이스에 많이 사용하여 static import를 사용하여  Assertions.생략 가능

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeansJunitTest {
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		// 1. Spring Bean Container 객체 생성
		// classpath에 xml 파일 경로 지정
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test
	void 생성자주입테스트() {
		Hello bean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3, names.size());
		assertEquals("Spring Boot", names.get(1));
	}
	
	@Test @Disabled
	void hello() {
		// 2. Container가 생성한 Bean을 요청하기
		Hello hello1 = (Hello) factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class); // 해당 방법 권장
		
		// 3. HelloBean의 레퍼런스 비교하기 
		System.out.println(hello1 == hello2); // 싱글톤인지 아닌지 확인 목적
		assertSame(hello1, hello2); // 주소가 같으면 테스트 성공으로 표시 
		
		assertEquals("Hello 스프링", hello2.sayHello()); // 예상한 값과 일치한지 확인
		hello2.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
}
