package chap09.collections;

import java.util.HashSet;
import java.util.Set;

import chap07.object.MyDate;

public class HashSetTest {

	public static void main(String[] args) {
		// �ߺ��� ������� �ʰ�, ������ �������� �ʴ´�.
		Set<String> mySet = new HashSet<>();

		mySet.add("�ڹ�");
		mySet.add("�ڹٽ�ũ��Ʈ");
		mySet.add("��Į��");
		mySet.add("�ڹ�");

		for (String value : mySet) {
			System.out.println(value);
		}

		Set<MyDate> dateSet = new HashSet<>();

		MyDate date1 = new MyDate(2020, 9, 2);
		System.out.println(date1.hashCode());
		dateSet.add(date1);
		
		MyDate date2 = new MyDate(2020, 11, 6);
		System.out.println(date2.hashCode());
		dateSet.add(date2);
		
		MyDate date3 = new MyDate(2020, 9, 2); // date1�� ���� ������, �ؽ��ڵ尡 �ٸ��� ������ ��µ� 
											   // hashCode Override�� �ذ�!
		System.out.println(date3.hashCode());
		dateSet.add(date3);
		
		for (MyDate myDate : dateSet) {
			System.out.println(myDate);
		}
	}

}