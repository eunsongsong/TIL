package workshop.animal.entity;

public class Spider extends Animal{
	
	
	public Spider(int legs) {
		super(legs);
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 파리를 먹는다.");
	}
	
}
