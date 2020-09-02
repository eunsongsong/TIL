package chap07.interfaces;

public class InterfaceTest {

	public static void main(String[] args) {
		// Bird ��ü�� �����ϴ� ���
		Bird bird1 = new Bird();
		bird1.eat();
		bird1.walk();
		bird1.fly();
		
		Animal bird2 = new Bird();
		bird2.eat();
		bird2.walk();
		
		Flyable bird3 = new Bird();
		bird3.fly();
		
		// AirPlane ��ü�� �����ϴ� ���
		AirPlane air1 = new AirPlane();
		Flyable air2 = new AirPlane();
	}

}
