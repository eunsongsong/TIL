package chap06.class1.overriding;

public class Parent {
	private final String MY_NAME;
	
	public Parent() {
		this("");
	}
	
	// blank final variable
	// ����� ���� �����ڿ��� �ʱ�ȭ �� �� �ִ�.
	public Parent(String name) {
		this.MY_NAME = name;
	}

	public final void doSomething() {
	}
}
