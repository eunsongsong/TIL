package chap03.types.referencetype;

// ��¥�� �Ӽ� : ��-��-��
/*
 * ��ü�� ������� �ʱ�ȭ 
 * i) default value�� �ʱ�ȭ - ��������� ����� ���ÿ� �ڵ����� �ʱ�ȭ�� �ȴ�.
 * ii) ������ �ʱ�ȭ 
 * iii) Constructor�� ���� �ʱ�ȭ 
 * */
// Java Beans, Value Object(VO), Data Transfer Object(DTO), Entity
public class MyDate {
	// �������, �ν��Ͻ� ����, ��ü ����
	// ���� ������ private�� Ŭ���� �������� ������ �� �ִ�.
	private int year = 2020; // ������ �ʱ�ȭ
	private int month; // default value�� �ʱ�ȭ - int���̱� ������ �ڵ����� 0
	private int day = 15; // ������ �ʱ�ȭ

	/*
	 * default constructor �����ϱ� constructor �̸��� �ݵ�� Ŭ�������� �Ȱ��ƾ� �Ѵ�. constructor�� ����
	 * Ÿ���� ����. (void�� �ƴϴ�.) constructor�� new �����ڸ� ���ؼ� ��ü�� ������ �� ȣ��Ǿ�����. ���������� �����ڰ�
	 * ������ constructor�� ������ �����Ϸ��� �ڵ����� �⺻ �����ڸ� ������ش�. ������, ���������� �����ڰ� ������
	 * constructor�� ������ �ڵ����� �������� �ʴ´�.
	 */

	public MyDate() {
		System.out.println("MyDate default constructor called...");
	}

	// constructor overloading(������ �ߺ�����)
	public MyDate(int year, int month, int day) {
//		this.year = year;
//		this.month = month;
//		this.day = day;
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	// �޴� - Source - Generate - toString
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	/* �޴� - Source - Generate - Getters and Setters */
	// year ������ ���� ��ȸ�� �� �ִ� �޼��� ���� - getter method
	public int getYear() {
		return this.year;
	}

	// year ������ ���� ������ �� �ִ� �޼��� ���� - setter method
	public void setYear(int year) {
		if (year >= 2000) {
			this.year = year;
		} else {
			System.out.println("year�� 2000�� ���� �⵵�� �����մϴ�.");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		// && : short circuit operator
		if(month >=1 && month <=12) {
			this.month = month;			
		} else {
			System.out.println("Month�� 1~12 ������ ���� �����մϴ�.");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day >= 1 & day <= 31) {
			this.day = day;			
		} else {
			System.out.println("Day�� 1~31 ������ ���� �����մϴ�.");
		}
	}
	
	
}