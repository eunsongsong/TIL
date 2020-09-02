package workshop.animal.entity;

public class Fish2 extends Animal2 implements Pet2{
	private String name;
	
	public Fish2() {
		super(0);
	}

	protected Fish2(int legs) {
		super(legs);
		// TODO Auto-generated constructor stub
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
		System.out.println("물고기는 물에서 놀아");
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
