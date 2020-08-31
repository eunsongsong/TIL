package chap03.types;

public class PrimitiveDataTypesTest {

	public static void main(String[] args) {
		// boolean true/false
		boolean isFlag = false;
		
		// char
		// sing quotation
		char gender = '\u0000'; // 초깃값 설정할 때 그냥 sing quotation만 쓸 수 없다.
		gender = '남';
		
		char gender2 = '남';
		
		if(gender == gender2) { 
			System.out.println("char 값이 같다.");
		}
		
		// String은 Primitive Data Type이 아니다. Reference Data type이다.
		// double quotation
		String name = "둘리";
		String name2 = new String("둘리");
		System.out.println(name2.toString());
		
		// 주소 비교
		if(name==name2) {
			System.out.println("String 값이 같다.");
		}
		// 값 비교
		if(name.equals(name2)) {
			System.out.println("String equals() 사용");
		}
		
		// 정수형 byte, short, int, long
		short n1 = 100;
		short n2 = 200;
		
		// Type mismatch: cannot convert from int to short
		// short result = n1 + n2; // 연산한 결과가 short 타입을 넘어감.
		int result = n1 + n2;
		short result2 = (short)(n1 + n2); // type casting 형변환
		
		//PrimitiveDataTypesTest 객체를 생성한 후에 method()를 호출할 수 있다.
		PrimitiveDataTypesTest test = new PrimitiveDataTypesTest();
		test.method(100);
		test.method(100L); // Long
		test.method(n1);
		
		// Type mismatch: cannot convert from double to float
		float pie = 3.14F;
		double pie2 = 3.14;
		float pie3 = (float)3.14; // type casting 형변환
		
	}
	
	// method 중복정의 (overloading)
	// overloading - 같은 클래스 내부에서 메서드명은 같고, 아규먼트 타입은 반드시 달라야 하고, 
	// 				  리턴 타임은 같을 수도 있고, 다를 수도 있다. 
	// method overloading의 장점?? 인터페이스가 간단(단순)해지는 장점이 있다.
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
