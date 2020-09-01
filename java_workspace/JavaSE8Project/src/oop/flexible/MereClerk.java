package oop.flexible;

/* ���� Ŭ���� */
public class MereClerk extends Employee {
    public MereClerk (String name, double salary) {
//      this.name = name;
//      this.salary = salary;
  	
  	/* �θ� Ŭ���� ������ ȣ�� */
  	// super �տ��� ��� ���嵵 �� �� ����!!
  	super(name, salary); 
  	System.out.println("MereClerk ������ ȣ��");
    }
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}
