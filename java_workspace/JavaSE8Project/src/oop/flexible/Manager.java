package oop.flexible;

/* 관리자 클래스 */
public class Manager extends Employee {
	private String dept;

	public Manager(String name, double salary) {
//        this.name = name;
//        this.salary = salary;

		/* 부모 클래스 생성자 호출 */
		// super 앞에는 어떠한 문장도 올 수 없어!!
		super(name, salary);
		System.out.println("Manager 생성자 호출");
	}

	public Manager(String name, double salary, String dept) {
		// 같은 클래스 내부에 있는 다른 생성자를 호출할 때 this()를 사용
		this(name, salary);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	// The type Manager must implement the inherited abstract method
	// Employee.manageSalary(double)
	@Override
	public void manageSalary(double rate) {
		salary = salary + salary * (rate / 100);
		salary += 20; // 20만원을 추가로 받는다.
	}

	@Override
	public String getDetails() {
		return super.getDetails() + "\n[부서명]" + dept;
	}
}
