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
		System.out.println("������ ������ ���");
	}

	@Override
	public void eat() {
		System.out.println("������ �� �ӿ��� �Ծ��");
	}
	
	@Override
	public void walk() {
		System.out.println("������ �ȱ� �ʰ� ����Ŀ�");
	}
	
}
