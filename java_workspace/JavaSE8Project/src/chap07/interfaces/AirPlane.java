package chap07.interfaces;

public class AirPlane implements Flyable {

	@Override
	public void fly() {
		System.out.println("비행기도 날 수 있다.");
	}

}
