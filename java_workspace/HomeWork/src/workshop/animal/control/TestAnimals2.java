package workshop.animal.control;

import workshop.animal.entity.Animal2;
import workshop.animal.entity.Cat2;
import workshop.animal.entity.Pet2;

public class TestAnimals2 {

	public static void main(String[] args) {
		// Cat ��ü�� �����ϴ� 3���� ���
		Cat2 cat1 = new Cat2();
		cat1.setName("�߿���");
		System.out.println(cat1.getName());
		cat1.play();
		cat1.eat();
		cat1.walk();
		
		Animal2 cat2 = new Cat2("����");
		cat2.eat();
		cat2.walk();
				
		Pet2 cat3 = new Cat2();
		cat3.setName("�ľ�");
		System.out.println(cat3.getName());
		cat3.play();
	}

}
