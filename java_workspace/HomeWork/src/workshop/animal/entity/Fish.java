package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;

	public Fish(String name) {
		super(0);
		this.name = name;
	}
	
	public Fish() {
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
		System.out.println(name+"은(는) 물에서 놀아요");
	}

	@Override
	public void eat() {
		System.out.println("물고기는 물 속에서 먹어요");
	}

	@Override
	public void walk() {
		System.out.println("물고기는 걷기 않고 헤엄쳐요");
	}

}
