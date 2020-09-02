package chap07.object;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate date1 = new MyDate(2020, 9, 2);
		MyDate date2 = new MyDate(2020, 9, 2);
		
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		
		// Object�� equals()�� ȣ��Ǿ��� ������ false
		// MyDate�� equals()�� ȣ��Ǿ��� ������ true
		System.out.println(date1.equals(date2)); // false/true
		System.out.println(date1 == date2); // false
	}

}