package workshop.animal.entity;

public class Spider2 extends Animal2{
	public Spider2() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 파리를 먹어요");
	}

}
