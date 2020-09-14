package myspring.di.annotation.test;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annotation.HelloBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class AnnotatedHelloBeanTest {
	@Autowired
	HelloBean hello;
	
	@Test
	public void helloBeanProps() {
		assertEquals("Hello ������̼�", hello.sayHello());
	}
	
	@Test @Ignore // constructor injection�� �׽�Ʈ �ϴ� �޼ҵ�
	public void helloBean() {
		assertEquals("Hello ������̼ǻ�����", hello.sayHello());
		hello.print();
	}
}
