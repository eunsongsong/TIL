package chap01.intro;
//
// Sample "Hello World" application
//
/**
 * Greeting 클래스의 greet() 메서드를 호출하는 실행 가능한 클래스입니다.
 * @author 이은송
 * */
public class TestGreeting {
   public static void main (String[] args) { // main이라는 메서드 있기 때문에 실행 가능
	   // Greeting 객체를 선언한다.
	   // Reference Data Type
      Greeting hello = new Greeting();
      // getClass().getName() + '@' + Integer.toHexString(hashCode())
      System.out.println(hello); // 클래스명@해시코드값 출력, 내부적으로 toString이 실행됨 
      System.out.println(hello.toString());
      System.out.println(hello.hashCode());
      System.out.println(Integer.toHexString(hello.hashCode()));
      hello.greet();
    }
 }

