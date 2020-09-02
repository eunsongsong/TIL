package chap09.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import chap07.object.MyDate;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList ��ü ���� (java 5.0 ���� ���)
		List list = new ArrayList();
		list.add("Hello"); // 0
		list.add("Java"); // 1
		list.add("Hello"); // ArrayList�� �ߺ� ok!
		list.add("JavaScript");
//		list.add(100); // �� ��ȯ���� ��������(22��)
					   // ������ ������ �߻����� ������ ������� ����
		
		String value = (String) list.get(1);
		System.out.println(value);

		System.out.println("For loop");
		for (int i = 0; i < list.size(); i++) {
			value = (String)list.get(i);
			System.out.println(value);
		}
		
		// ArrayList ��ü ����(java 5.0 ���� ���)
		List<String> mylist1 = new ArrayList<String>(); // 5.0
		List<String> mylist2 = new ArrayList<>(); // 7.0
		mylist2.add("ȫ�浿");
		mylist2.add("�Ѹ�");
		mylist2.add("ȫ�浿");
//		mylist2.add(100); // String���� �̹� �����߱� ������ ������ ���� �߻�
		
		for(String val : mylist2) {
			System.out.println(val);
		}
		
		// MyDate ��ü�� ArrayList�� ����
		List<MyDate> dateList = new ArrayList<>();
		dateList.add(new MyDate(2020, 11, 30));
		dateList.add(new MyDate(2020, 9, 2));
		dateList.add(new MyDate(2020, 11, 30));
		
		for(MyDate date : dateList) {
			System.out.println(date);
		}
		
		System.out.println("---using iterator");
		// alt + shift + L : ���� Ÿ�� �ڵ��ϼ�
		// Iterator ���
		Iterator<MyDate> iterator = dateList.iterator();
		
		MyDate date = null;
		while(iterator.hasNext()) {
			date = iterator.next();
			System.out.println(date);
		}
	}
	
	public void myIteration(Collection<MyDate> cols) {
		Iterator<MyDate> iterator = cols.iterator();
		
		MyDate date = null;
		while(iterator.hasNext()) {
			date = iterator.next();
			System.out.println(date);
		}
	}

}