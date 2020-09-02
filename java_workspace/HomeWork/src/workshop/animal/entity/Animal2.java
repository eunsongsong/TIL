package workshop.animal.entity;

public abstract class Animal2 {
	protected int legs;
	
	protected Animal2(int legs) {
		this.legs = legs;
	}
	
	public abstract void eat();
	
	public void walk() {
		System.out.println(legs+"개 다리로 걸어요");
	}
	
}
