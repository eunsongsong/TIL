package oop.flexible;

/* 평사원 클래스 */
public class MereClerk extends Employee {
    public MereClerk (String name, double salary) {
//      this.name = name;
//      this.salary = salary;
  	
  	/* 부모 클래스 생성자 호출 */
  	// super 앞에는 어떠한 문장도 올 수 없어!!
  	super(name, salary); 
  	System.out.println("MereClerk 생성자 호출");
    }
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}
