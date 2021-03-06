package chap03.types.referencetype;

// 날짜의 속성 : 년-월-일
/*
 * 객체의 멤버변수 초기화 
 * i) default value로 초기화 - 멤버변수의 선언과 동시에 자동으로 초기화가 된다.
 * ii) 명시적 초기화 
 * iii) Constructor에 의한 초기화 
 * */
// Java Beans, Value Object(VO), Data Transfer Object(DTO), Entity
public class MyDate {
	// 멤버변수, 인스턴스 변수, 객체 변수
	// 접근 제한자 private는 클래스 내에서만 접근할 수 있다.
	private int year = 2020; // 명시적 초기화
	private int month; // default value로 초기화 - int형이기 때문에 자동으로 0
	private int day = 15; // 명시적 초기화

	/*
	 * default constructor 선언하기 constructor 이름은 반드시 클래스명과 똑같아야 한다. constructor는 리턴
	 * 타입이 없다. (void도 아니다.) constructor는 new 연산자를 통해서 객체가 생성될 때 호출되어진다. 명시적으로 개발자가
	 * 정의한 constructor가 없으면 컴파일러가 자동으로 기본 생성자를 만들어준다. 하지만, 명시적으로 개발자가 정의한
	 * constructor가 있으면 자동으로 생성하지 않는다.
	 */

	public MyDate() {
		System.out.println("MyDate default constructor called...");
	}

	// constructor overloading(생성자 중복정의)
	public MyDate(int year, int month, int day) {
//		this.year = year;
//		this.month = month;
//		this.day = day;
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	// 메뉴 - Source - Generate - toString
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	/* 메뉴 - Source - Generate - Getters and Setters */
	// year 변수의 값을 조회할 수 있는 메서드 선언 - getter method
	public int getYear() {
		return this.year;
	}

	// year 변수의 값을 변경할 수 있는 메서드 선언 - setter method
	public void setYear(int year) {
		if (year >= 2000) {
			this.year = year;
		} else {
			System.out.println("year는 2000년 이후 년도만 가능합니다.");
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
			System.out.println("Month는 1~12 사이의 값만 가능합니다.");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day >= 1 & day <= 31) {
			this.day = day;			
		} else {
			System.out.println("Day는 1~31 사이의 값만 가능합니다.");
		}
	}
	
	
}
