package chap03.types;

public class PrimitiveDataTypesTest {

	public static void main(String[] args) {
		// boolean true/false
		boolean isFlag = false;
		
		// char
		// sing quotation
		char gender = '\u0000'; // �ʱ갪 ������ �� �׳� sing quotation�� �� �� ����.
		gender = '��';
		
		char gender2 = '��';
		
		if(gender == gender2) { 
			System.out.println("char ���� ����.");
		}
		
		// String�� Primitive Data Type�� �ƴϴ�. Reference Data type�̴�.
		// double quotation
		String name = "�Ѹ�";
		String name2 = new String("�Ѹ�");
		System.out.println(name2.toString());
		
		// �ּ� ��
		if(name==name2) {
			System.out.println("String ���� ����.");
		}
		// �� ��
		if(name.equals(name2)) {
			System.out.println("String equals() ���");
		}
		
		// ������ byte, short, int, long
		short n1 = 100;
		short n2 = 200;
		
		// Type mismatch: cannot convert from int to short
		// short result = n1 + n2; // ������ ����� short Ÿ���� �Ѿ.
		int result = n1 + n2;
		short result2 = (short)(n1 + n2); // type casting ����ȯ
		
		//PrimitiveDataTypesTest ��ü�� ������ �Ŀ� method()�� ȣ���� �� �ִ�.
		PrimitiveDataTypesTest test = new PrimitiveDataTypesTest();
		test.method(100);
		test.method(100L); // Long
		test.method(n1);
		
		// Type mismatch: cannot convert from double to float
		float pie = 3.14F;
		double pie2 = 3.14;
		float pie3 = (float)3.14; // type casting ����ȯ
		
	}
	
	// method �ߺ����� (overloading)
	// overloading - ���� Ŭ���� ���ο��� �޼������ ����, �ƱԸ�Ʈ Ÿ���� �ݵ�� �޶�� �ϰ�, 
	// 				  ���� Ÿ���� ���� ���� �ְ�, �ٸ� ���� �ִ�. 
	// method overloading�� ����?? �������̽��� ����(�ܼ�)������ ������ �ִ�.
	public void method(byte number) {
		System.out.println("I'm byte");
	}
	public void method(short number) {
		System.out.println("I'm short");
	}
	public void method(int number) {
		System.out.println("I'm int");
	}
	public void method(long number) {
		System.out.println("I'm long");
	}

}
