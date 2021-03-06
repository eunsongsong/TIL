package oop.flexible;

public class InheritanceTest {

	public static void main(String[] args) {
		Manager manager = new Manager("홍길동", 5000);

		
		// Manager 객체를 생성하는 방법
		Manager manager2 = new Manager("펭수", 5000, "인사부"); // 1)
		Employee manager3 = new Manager("키티",4500,"관리부"); // 2)
		
		/*
		 * getDept는 Employee로 부터 상속받은 것이 아니라 Manager 단독으로 가지고 있는 것이기 때문에 
		 * manager3.getDept(); (x)
		 * */
		
		// type casting 형변환
		if(manager3 instanceof Manager) {
			Manager mgr = (Manager)manager3;
			System.out.println(mgr.getDept());
			
			System.out.println(((Manager)manager3).getDept());
		}
		
		
		MereClerk clerk = new MereClerk("둘리", 3000);		
		
		System.out.println(manager.getDetails());
		System.out.println(manager2.getDetails());
		System.out.println(clerk.getDetails());
		
//		System.out.println(manager.getName() + " " + manager.getSalary());
//		System.out.println(clerk.getName() + " " + clerk.getSalary());
		
		// Cannot instantiate the type Employee
		// Employee emp = new Employee; (X)

	}

}
