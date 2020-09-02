package chap07.interfaces;

public class InterfaceTest {

	public static void main(String[] args) {
		// Bird 按眉甫 积己窍绰 规过
		Bird bird1 = new Bird();
		bird1.eat();
		bird1.walk();
		bird1.fly();
		
		Animal bird2 = new Bird();
		bird2.eat();
		bird2.walk();
		
		Flyable bird3 = new Bird();
		bird3.fly();
		
		// AirPlane 按眉甫 积己窍绰 规过
		AirPlane air1 = new AirPlane();
		Flyable air2 = new AirPlane();
	}

}
