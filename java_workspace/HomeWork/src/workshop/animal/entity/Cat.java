package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	public String name;

	public Cat(int legs, String name) {
		super(legs);
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 털뭉치를 좋아해");
		
	}

	@Override
	public void eat() {
		System.out.println("고양이는 츄르를 좋아해");
		
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
