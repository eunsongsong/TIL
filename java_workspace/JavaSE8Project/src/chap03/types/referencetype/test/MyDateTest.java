package chap03.types.referencetype.test;

import chap03.types.referencetype.MyDate;

// ctrl + spacebar Ŭ���� �̸� �ڵ��ϼ��ϸ� �ڵ����� import�� ���� �ȴ�.
// ctrl + shift + o : organize import
public class MyDateTest {
	public static void main(String[] args) {
		// 1. MyDate ��ü �����ϱ�
		MyDate date1 = new MyDate();
		
		System.out.println(date1);
//		System.out.println(date1.year);
//		System.out.println(date1.month);
//		System.out.println(date1.day);
		System.out.println(date1.getYear());
		System.out.println(date1.getMonth());
		System.out.println(date1.getDay());
		
		
		// colum blocking : alt + shift + a
		MyDate date2 = new MyDate(2020, 8, 31); // �����ڿ� ���� �ʱ�ȭ
		System.out.println(date2);
//		System.out.println(date2.year);
//		System.out.println(date2.month);
//		System.out.println(date2.day);
		System.out.println(date2.getYear());
		System.out.println(date2.getMonth());
		System.out.println(date2.getDay());
		
		// ���� �����ڰ� public�� �Ǿ��ֱ� ������ �ܺο��� ������ �� �ִ�. 
		// �ܺο��� ���� ������ ���, �߸��� ������ ����Ǵ� ������ �߻��� �� �ִ�.
		// ���� ���� �������� ������ private�� �����ش�.
		// ���, ���� ��ȸ�� �� �ֵ��� ���� �����ϴ� �Լ�(getter method)�� ������ش�.
//		date2.year = 2020;
		date2.setYear(2020);
//		date2.month = 13; // 13���� ���� ��. ������ ������ �߻����� ������, �������� ������ �߻��� �� �ִ�.
		date2.setMonth(13);
//		date2.day = 40;
		date2.setDay(40);
		System.out.println(date2.toString());
		
		
		MyDate date3 = new MyDate(1999,13,45);
		System.out.println("date3 "+date3);
	}
}
