package chap07.class2.statics;

public class MyCountTest {

	public static void main(String[] args) {
		MyCount count1 = new MyCount(); // ��ü �ѹ� ���� counter+1
		MyCount count2 = new MyCount(); // ��ü �ѹ� �� ���� counter+1(����)
		
		System.out.println(count1.getSerialNumber()); // 1
		
		count1 = null;
		// Ŭ���� ����, �޼���� ��ü�� �ּҷ� �������� �ʴ´�.
		// static ����, �޼���� Ŭ������ ���� ������ �޼����̱� ������ ��ü ������ �����ϴ�.
		System.out.println(count1.getCounter()); // 2
		
		System.out.println(count2.getSerialNumber()); // 1 
		System.out.println(MyCount.getCounter()); // 2
	}

}