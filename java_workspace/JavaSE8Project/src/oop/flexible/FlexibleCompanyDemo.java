package oop.flexible;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		// Heterogeneous Collection 생성
		Employee[] emps = new Employee[3];
		emps[0] = new MereClerk("철수", 100);
		emps[1] = new MereClerk("영희", 100);
		emps[2] = new Manager("홍길동", 200, "개발부");

		System.out.println("현재 월급입니다.");
		printEmployeeInfo(emps);

		System.out.println("");

		System.out.println("올린 후의 월급입니다.");
		for (Employee emp : emps) {
			emp.manageSalary(10);
		}
		printEmployeeInfo(emps);

	} // main

	private static void printEmployeeInfo(Employee[] emps) {
		for (Employee emp : emps) {
			if(emp instanceof Manager) {
//				Manager mgr = (Manager)emp;
//				System.out.print(mgr.getDept()+" ");	
				System.out.print(((Manager)emp).getDept()+ " ");
			}
			System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
		}
	}
}
