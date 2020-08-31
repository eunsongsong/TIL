package chap05.arrays;

import chap03.types.referencetype.MyDate;

public class ReferenceTypeArrayTest {

	public static void main(String[] args) {

		// String type Array
		String[] myStrs = new String[3];

		System.out.println(myStrs);
		System.out.println(myStrs[0]);
		System.out.println(myStrs[1]);
		System.out.println(myStrs[2]);

		// myStrs[0]�� string type
		myStrs[0] = new String("�ڷ����");
		myStrs[1] = "���";
		myStrs[2] = new String("�Ѹ�");

		for (String val : myStrs) {
			System.out.println(val);
		}

		// MyDate type Array
		MyDate[] myDates = new MyDate[3];
		System.out.println(myDates);
		System.out.println(myDates[0]);
		
		ReferenceTypeArrayTest test = new ReferenceTypeArrayTest();
		test.fillArray(myDates);
		test.printArray(myDates);

	} // main

	public void fillArray(MyDate[] dates) {
		// myDates[0]�� MyDate Ÿ���̴�.
		dates[0] = new MyDate(2020, 1, 30);
		dates[1] = new MyDate(2020, 2, 25);
		dates[2] = new MyDate(2020, 8, 31);

	}

	public void printArray(MyDate[] myDates) {
		for (MyDate date : myDates) {
			System.out.println("[��]"+date.getYear()+"\t[��]"+date.getMonth()+"\t[��]"+date.getDay());
//			System.out.println(date);
		}

	}

}
