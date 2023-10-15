package myspring.di.annot;

import org.springframework.stereotype.Component;

// target : 클래스 위에 선언할 수 있음
// retention : runtime에 실행됨을 보장
// id 설정 안하면 소문자 클래스명으로 자동 설정됨
@Component("stringPrinter")
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	public StringPrinter() {
		System.out.println(this.getClass().getName() + "생성자 호출됨");
	}
	
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
