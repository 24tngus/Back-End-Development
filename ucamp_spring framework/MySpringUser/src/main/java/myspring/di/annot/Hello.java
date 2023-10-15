package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// xml파일의 bean 태그와 동일
@Component("helloBean")
public class Hello {
	
	// property 속성의 value와 동일
	@Value("어노테이션")
	String name;
	
	// preoverty 속성의 ref와 동일
	@Autowired
	@Qualifier("stringPrinter")
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + "생성자 호출됨");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + "오버로딩된 생성자 호출됨");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("Hello setNames() " + list);
		this.names = list;
	}

	// 어노테이션 사용시 없어도 됨
//	public void setName(String name) {
//		System.out.println("Hello setName() " + name);
//		this.name = name;
//	}
//
//	public void setPrinter(Printer printer) {
//		System.out.println("Hello setPrinter " + printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
