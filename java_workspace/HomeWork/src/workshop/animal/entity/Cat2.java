package workshop.animal.entity;

public class Cat2 extends Animal2 implements Pet2 {
	private String name;
	
	// Implicit super constructor Animal2() is undefined.
	// Must explicitly invoke another constructor
	public Cat2(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat2() {
		this("");
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 털뭉치를 좋아해");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 츄르를 잘먹어");
	}
	
	
}
