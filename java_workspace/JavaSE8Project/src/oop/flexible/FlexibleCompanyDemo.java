package oop.flexible;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		// Heterogeneous Collection ����
		Employee[] emps = new Employee[3];
		emps[0] = new MereClerk("ö��", 100);
		emps[1] = new MereClerk("����", 100);
		emps[2] = new Manager("ȫ�浿", 200, "���ߺ�");

		System.out.println("���� �����Դϴ�.");
		printEmployeeInfo(emps);

		System.out.println("");

		System.out.println("�ø� ���� �����Դϴ�.");
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
			System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");
		}
	}
}