package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;

// Bean 컨테이너 종류가 바뀌어서 loader를 통해 가져옴
// AnnotationConfigContextLoader.class는 AnnotationConfigApplicationContext 라는 Spring Bean Container를 로딩해주는 Loader 클래스
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedHelloConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotatedHelloConfigTest {
	@Autowired
	Hello hello;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello()); // Hello 어노테이션
	}
}
