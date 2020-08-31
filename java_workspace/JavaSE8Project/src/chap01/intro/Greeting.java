package chap01.intro;
//
// The Greeting class declaration.
//
/*
 * Ŭ�������� �빮�ڷ� �����Ѵ�.(camel case)
 * ��Ű������ �ҹ��ڷ� �����Ѵ�.
 * �޼����� �������� �ҹ��ڷ� �����Ѵ�.
 * �޼�����̳� �������� �ܾ �ٲ�� �ٲ�� ù���ڴ� �빮�ڷ� �Ѵ�.(camel case)
 * ��) getMessage() (o),  getmessage() (x)
 * */
/**
 * Greeting Ŭ����
 * @author ������
 * @version v1.0
 * */
 public class Greeting { // main �޼ҵ� ���� ������ �ܵ� ���� �Ұ��� 
	 String message = "�޼���";
	 
    /**
     * �λ縻�� ����ϴ�  greet �޼���
     * */
	 public void greet() { // void - �ڵ带 ���������� ��ȯ�ϴ� �� ����
       System.out.println("hi");
    }

	 // object �θ� Ŭ������ ������� toString() �޼��带 ������(overriding)�ϱ�
	 /*
	  * overriding ��Ģ
	  * 1. �������ϴ� ����δ� �ݵ�� ���ƾ� �Ѵ�
	  * 2. �����δ� �޶�� �Ѵ�.
	  * @override ������̼��� ������ Ÿ�ӿ� �޼��� ������ ��Ģ�� �ؼ��ߴ����� üũ���ִ� �����̴�.
	  * override - ��� ���谡 �����Ǿ� �־��� �Ѵ�.
	  * */
	 @Override
	public String toString() {
		// super - �θ� Ŭ������ ����Ű�� keyword
		// return super.toString();
		
		// this - �ڱ� �ڽ��� ����Ű�� keyword
		return this.message;
	}
	 
  }
