package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	public Fish(int legs) {
		super(legs);
	}

	public String name;
	
	@Override
	public void play() {
		System.out.println("������ ��������");
	}
	
	@Override
	public void eat() {
		System.out.println("������ �� �ӿ��� ���̸� �Դ´�.");
	}
	
	@Override
	public void walk() {
		System.out.println("������ �ٸ��� "+legs+"��, ������ ���ģ��.");
	}

	@Override
	public String setName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
