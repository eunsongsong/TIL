package chap07.interfaces;

public class Bird extends Animal implements Flyable {

	@Override
	public void fly() {
		System.out.println("���� �� �� �ִ�.");
	}

	@Override
	public void eat() {
		System.out.println("���� ������ �Դ´�.");
	}

}
