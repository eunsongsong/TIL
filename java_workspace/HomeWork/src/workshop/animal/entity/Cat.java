package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	public String name;

	public Cat(int legs, String name) {
		super(legs);
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("����̴� �й�ġ�� ������");
		
	}

	@Override
	public void eat() {
		System.out.println("����̴� �򸣸� ������");
		
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
