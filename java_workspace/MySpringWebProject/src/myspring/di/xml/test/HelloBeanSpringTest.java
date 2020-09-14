package myspring.di.xml.test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	@Qualifier("helloC") // 변수명과 다른 bean id를 가지고 오고 싶을 때
	Hello hello;
	
	@Autowired
	@Qualifier("hello")
	Hello hellos;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Test @Ignore // @Ignore 일시적으로 @Test 메서드 중지
	public void helloBeanConstructor() {
		System.out.println(hello.sayHello());
		hello.print();
	}
	
	@Test
	public void helloBeanSetter() {
		assertEquals("Hello 스프링", hellos.sayHello());
		hellos.print();
		assertEquals("Hello 스프링", printer.toString());
	}
}
