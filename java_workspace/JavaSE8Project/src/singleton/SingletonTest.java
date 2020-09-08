package singleton;

public class SingletonTest {

	public static void main(String[] args) {
//		ExampleClass = new ExampleClass();
		ExampleClass instance1 = ExampleClass.getInstance();
		ExampleClass instance2 = ExampleClass.getInstance();

		System.out.println(instance1 == instance2);
	}

}
