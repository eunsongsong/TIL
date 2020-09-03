package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Animal2;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Cat2;
import workshop.animal.entity.Fish;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Pet2;
import workshop.animal.entity.Spider;

public class TestAnimals {

	public static void main(String[] args) {
		Fish f = new Fish("�غ���");
		System.out.println(f.getName());
		f.eat();
		f.walk();
		f.play();
		Cat c = new Cat("Fluffy");
		System.out.println(c.getName());
		c.eat();
		c.walk();
		c.play();
		Animal af = new Fish();
		af.eat();
		af.walk();
		Animal as = new Spider();
		as.eat();
		as.walk();
		Pet pc = new Cat();
		pc.setName("�ľ�");
		System.out.println(pc.getName());
		
		
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
