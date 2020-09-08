package myspring.di.xml.test;

// Assert Ŭ������ �ִ� ��� static method�� import �Ѵ�.
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {

	// test method ����� public void �̾�� �Ѵ�.
	// @Test ������̼��� �ݵ�� ������ �־�� �Ѵ�!!
	@Test
	public void helloBean() {
		// 1. Spring Bean Container ��ü�� ����
		BeanFactory factory = new GenericXmlApplicationContext("config/spring_beans.xml");
		// 2. Bean Container���� Hello Bean�� ��û�ϱ�
		// Hello hello = new Hello(); (X)
		Hello hello = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		
		System.out.println(hello == hello2);
		// Junit���� �����ϴ� ��ü�� �ּҸ� ���� �ִ� �޼���
//		Assert.assertSame(hello, hello2);
		assertSame(hello, hello2);
		// Junit���� �����ϴ� ��ü�� ���� ���� �ִ� �޼���
//		Assert.assertEquals("Hello ������", hello.sayHello());
		assertEquals("Hello ������", hello.sayHello());
		
		hello.print();
		
		// Bean Container���� StringPrinter Bean�� ��û�ϱ�
		Printer printer = factory.getBean("strPrinter", Printer.class);		
		assertEquals("Hello ������", printer.toString());
	}
}





