package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Fish;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Spider;

public class TestAnimals {

	public static void main(String[] args) {
		Fish f = new Fish(0); 
		f.eat();
		f.walk();
		f.play();
		Cat c = new Cat(4,"fluffy"); 
		c.eat();
		c.walk();
		c.play();
		Animal s = new Spider(8);
		s.eat();
		s.walk();
		Pet pc = new Cat(4,"����"); 
		pc.play();

	}

}
