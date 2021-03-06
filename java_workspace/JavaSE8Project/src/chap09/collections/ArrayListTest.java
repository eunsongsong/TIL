package chap09.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import chap07.object.MyDate;

public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList 객체 생성 (java 5.0 이전 방식)
		List list = new ArrayList();
		list.add("Hello"); // 0
		list.add("Java"); // 1
		list.add("Hello"); // ArrayList는 중복 ok!
		list.add("JavaScript");
//		list.add(100); // 형 변환에서 문제생김(22줄)
					   // 컴파일 오류는 발생하지 않지만 실행되지 않음
		
		String value = (String) list.get(1);
		System.out.println(value);

		System.out.println("For loop");
		for (int i = 0; i < list.size(); i++) {
			value = (String)list.get(i);
			System.out.println(value);
		}
		
		// ArrayList 객체 생성(java 5.0 이후 방식)
		List<String> mylist1 = new ArrayList<String>(); // 5.0
		List<String> mylist2 = new ArrayList<>(); // 7.0
		mylist2.add("홍길동");
		mylist2.add("둘리");
		mylist2.add("홍길동");
//		mylist2.add(100); // String으로 이미 선언했기 때문에 컴파일 오류 발생
		
		for(String val : mylist2) {
			System.out.println(val);
		}
		
		// MyDate 객체를 ArrayList에 저장
		List<MyDate> dateList = new ArrayList<>();
		dateList.add(new MyDate(2020, 11, 30));
		dateList.add(new MyDate(2020, 9, 2));
		dateList.add(new MyDate(2020, 11, 30));
		
		for(MyDate date : dateList) {
			System.out.println(date);
		}
		
		System.out.println("---using iterator");
		// alt + shift + L : 리턴 타입 자동완성
		// Iterator 사용
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
