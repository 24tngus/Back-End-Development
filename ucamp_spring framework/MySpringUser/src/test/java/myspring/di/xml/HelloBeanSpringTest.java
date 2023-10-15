package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Spring Bean Container 객체 생성 대신 @ExtendWith 사용 (싱글톤의 Application Context 보장)
// classpath로 경로 설정 대신 @ContextConfiguration (스프링 빈 설정 파일의 위치)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	// 1/ getBean 대신에 @Autowired 의존 받고 싶은 타입을 자동 연결
	// type이 동일할 경우 Bean의 변수명과 Bean의 id가 동일한 것을 찾아옴 (동일한게 없을 경우 찾을 수 없다고 표시)
	@Autowired
	Hello hello;
	
	@Autowired
	// 2. Qualifier : 범위 한정자 (Autowired와 함께 기재)
	@Qualifier("helloC")
	Hello hello2;
	
	// 3. 원하는 Bean의 id 값으로 가져옴
	@Resource(name = "helloC")
	Hello hello3;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	//@Autowired
	//StringPrinter printer;

	@Test
	void helloC() {
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
	}
	
	@Test // @Disabled
	void hello() {
		assertEquals("Hello 스프링", hello.sayHello()); // import static으로 인해 Assertions.assertEquals와 동일
		
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
	}
	
}
