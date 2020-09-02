package chap07.object;

public class StringTest {

	public static void main(String[] args) {
		// equals
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		String str5 = new String("Hello");
		String str6 = str3;
		
		// �� ��
		System.out.println("str1.equals(str2) : " + str1.equals(str2)); // true
		// �ּ� ��
		System.out.println("str1 == str3 : " + (str1 == str3)); // false
		System.out.println("str1 == str2 : " + (str1 == str2)); // true
		System.out.println("str3 == str4 : " + (str3 == str4)); // false
		System.out.println("str3.equals(str4) : " + str3.equals(str4)); // true
		System.out.println("str4.equals(str5) : " + str4.equals(str5)); // false
		System.out.println("str3.equalsIgnoreCase(str5) : " + str3.equalsIgnoreCase(str5)); // true
		System.out.println("str6 == str3 : " + str6 == str3); // true
		
		System.out.println(str3.toString());
		
		Integer num = new Integer(100);
		System.out.println(num.toString());
		
		Integer num2 = 100; // Integer Ÿ�Կ� int Ÿ���� ���� AutoBoxing
		
		int num3 = num; // int Ÿ�Կ� Integer Ÿ���� ���� UnBoxing
	}

}