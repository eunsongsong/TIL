package chap07.class2.statics;

public class MyCountTest {

	public static void main(String[] args) {
		MyCount count1 = new MyCount(); // 객체 한번 생성 counter+1
		MyCount count2 = new MyCount(); // 객체 한번 더 생성 counter+1(누적)
		
		System.out.println(count1.getSerialNumber()); // 1
		
		count1 = null;
		// 클래스 변수, 메서드는 객체의 주소로 접근하지 않는다.
		// static 변수, 메서드는 클래스에 속한 변수나 메서드이기 때문에 객체 생성과 무관하다.
		System.out.println(count1.getCounter()); // 2
		
		System.out.println(count2.getSerialNumber()); // 1 
		System.out.println(MyCount.getCounter()); // 2
	}

}
