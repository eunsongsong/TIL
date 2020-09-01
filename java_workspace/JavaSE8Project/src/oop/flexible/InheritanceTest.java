package oop.flexible;

public class InheritanceTest {

	public static void main(String[] args) {
		Manager manager = new Manager("ȫ�浿", 5000);

		
		// Manager ��ü�� �����ϴ� ���
		Manager manager2 = new Manager("���", 5000, "�λ��"); // 1)
		Employee manager3 = new Manager("ŰƼ",4500,"������"); // 2)
		
		/*
		 * getDept�� Employee�� ���� ��ӹ��� ���� �ƴ϶� Manager �ܵ����� ������ �ִ� ���̱� ������ 
		 * manager3.getDept(); (x)
		 * */
		
		// type casting ����ȯ
		if(manager3 instanceof Manager) {
			Manager mgr = (Manager)manager3;
			System.out.println(mgr.getDept());
			
			System.out.println(((Manager)manager3).getDept());
		}
		
		
		MereClerk clerk = new MereClerk("�Ѹ�", 3000);		
		
		System.out.println(manager.getDetails());
		System.out.println(manager2.getDetails());
		System.out.println(clerk.getDetails());
		
//		System.out.println(manager.getName() + " " + manager.getSalary());
//		System.out.println(clerk.getName() + " " + clerk.getSalary());
		
		// Cannot instantiate the type Employee
		// Employee emp = new Employee; (X)

	}

}
