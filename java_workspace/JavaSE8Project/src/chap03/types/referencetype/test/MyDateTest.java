package chap03.types.referencetype.test;

import chap03.types.referencetype.MyDate;

// ctrl + spacebar 클래스 이름 자동완성하면 자동으로 import도 같이 된다.
// ctrl + shift + o : organize import
public class MyDateTest {
	public static void main(String[] args) {
		// 1. MyDate 객체 생성하기
		MyDate date1 = new MyDate();
		
		System.out.println(date1);
//		System.out.println(date1.year);
//		System.out.println(date1.month);
//		System.out.println(date1.day);
		System.out.println(date1.getYear());
		System.out.println(date1.getMonth());
		System.out.println(date1.getDay());
		
		
		// colum blocking : alt + shift + a
		MyDate date2 = new MyDate(2020, 8, 31); // 생성자에 의한 초기화
		System.out.println(date2);
//		System.out.println(date2.year);
//		System.out.println(date2.month);
//		System.out.println(date2.day);
		System.out.println(date2.getYear());
		System.out.println(date2.getMonth());
		System.out.println(date2.getDay());
		
		// 접근 제한자가 public로 되어있기 때문에 외부에서 변경할 수 있다. 
		// 외부에서 값을 변경할 경우, 잘못된 값으로 변경되는 문제가 발생할 수 있다.
		// 따라서 접근 제한자의 범위를 private로 좁혀준다.
		// 대신, 값을 조회할 수 있도록 값을 리턴하는 함수(getter method)를 만들어준다.
//		date2.year = 2020;
		date2.setYear(2020);
//		date2.month = 13; // 13월은 없는 달. 컴파일 오류는 발생하지 않지만, 로직상의 오류가 발생할 수 있다.
		date2.setMonth(13);
//		date2.day = 40;
		date2.setDay(40);
		System.out.println(date2.toString());
		
		
		MyDate date3 = new MyDate(1999,13,45);
		System.out.println("date3 "+date3);
	}
}
