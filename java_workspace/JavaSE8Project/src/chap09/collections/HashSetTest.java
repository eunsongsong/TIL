package chap09.collections;

import java.util.HashSet;
import java.util.Set;

import chap07.object.MyDate;

public class HashSetTest {

	public static void main(String[] args) {
		// 중복을 허용하지 않고, 순서도 유지되지 않는다.
		Set<String> mySet = new HashSet<>();

		mySet.add("자바");
		mySet.add("자바스크립트");
		mySet.add("스칼라");
		mySet.add("자바");

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
		
		MyDate date3 = new MyDate(2020, 9, 2); // date1과 값이 같지만, 해시코드가 다르기 때문에 출력됨 
											   // hashCode Override로 해결!
		System.out.println(date3.hashCode());
		dateSet.add(date3);
		
		for (MyDate myDate : dateSet) {
			System.out.println(myDate);
		}
	}

}
