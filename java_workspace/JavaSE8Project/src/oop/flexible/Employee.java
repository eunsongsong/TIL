package oop.flexible;

/*
 * Employee emp = new Employee() (x)
 * 추상 클래스는 스스로 객체를 생성할 수 없다.
 * Employee mgr = new Manager() (o)
 * Employee clerk = new MereClerk() (o)
 * abstract method(body가 없는 메서드)도 선언할 수 있고, 
 * concrete method(body가 있는 메서드)도 선언할 수 있다.
 * */

public abstract class Employee {

	// 접근제한자
	// public - 어디서나 참조 가능
	// protected - default 참조 범위 및 상속 관계에 있을 때 package에 관계 없이 참조 가능
	// default - 같은 디렉토리(같은 package) 내의 다른 클래스 참조 가능
	// private - 클래스 내부에서만 참조 가능
	// (클래스는 public, default 접근 제한자만 가능)
	private String name;
	protected double salary;

	public Employee() {
		super();
	}

	// Constructor overloading
	public Employee(String name, double salary) {
		System.out.println("Employee 생성자 호출");
		this.name = name;
		this.salary = salary;
	}

	// concrete method - body({})가 있는 메서드
	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}
	
	public String getDetails() {
		return "[name]" + name + "\n" + "[Salary]" + salary;
	}

	// The abstract method manageSalary in type Employee can only be defined by an abstract class
	// body({})가 없는 abstract method 선언
	// 자식클래스에게 method 구현을 강제하고 싶을 때 추상메서드로 선언한다. 
	public abstract void manageSalary(double rate);
}