package oop.flexible;

/* ������ Ŭ���� */
public class Manager extends Employee {
	private String dept;

	public Manager(String name, double salary) {
//        this.name = name;
//        this.salary = salary;

		/* �θ� Ŭ���� ������ ȣ�� */
		// super �տ��� ��� ���嵵 �� �� ����!!
		super(name, salary);
		System.out.println("Manager ������ ȣ��");
	}

	public Manager(String name, double salary, String dept) {
		// ���� Ŭ���� ���ο� �ִ� �ٸ� �����ڸ� ȣ���� �� this()�� ���
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
		salary += 20; // 20������ �߰��� �޴´�.
	}

	@Override
	public String getDetails() {
		return super.getDetails() + "\n[�μ���]" + dept;
	}
}