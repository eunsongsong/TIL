package chap01.intro;
//
// Sample "Hello World" application
//
/**
 * Greeting Ŭ������ greet() �޼��带 ȣ���ϴ� ���� ������ Ŭ�����Դϴ�.
 * @author ������
 * */
public class TestGreeting {
   public static void main (String[] args) { // main�̶�� �޼��� �ֱ� ������ ���� ����
	   // Greeting ��ü�� �����Ѵ�.
	   // Reference Data Type
      Greeting hello = new Greeting();
      // getClass().getName() + '@' + Integer.toHexString(hashCode())
      System.out.println(hello); // Ŭ������@�ؽ��ڵ尪 ���, ���������� toString�� ����� 
      System.out.println(hello.toString());
      System.out.println(hello.hashCode());
      System.out.println(Integer.toHexString(hello.hashCode()));
      hello.greet();
    }
 }

