package chap01.intro;
//
// The Greeting class declaration.
//
/*
 * 클래스명은 대문자로 시작한다.(camel case)
 * 패키지명은 소문자로 시작한다.
 * 메서드명과 변수명은 소문자로 시작한다.
 * 메서드명이나 변수명에서 단어가 바뀌면 바뀌는 첫글자는 대문자로 한다.(camel case)
 * 예) getMessage() (o),  getmessage() (x)
 * */
/**
 * Greeting 클래스
 * @author 이은송
 * @version v1.0
 * */
 public class Greeting { // main 메소드 없기 때문에 단독 실행 불가능 
	 String message = "메세지";
	 
    /**
     * 인사말을 출력하는  greet 메서드
     * */
	 public void greet() { // void - 코드를 실행하지만 반환하는 값 없음
       System.out.println("hi");
    }

	 // object 부모 클래스가 상속해준 toString() 메서드를 재정의(overriding)하기
	 /*
	  * overriding 규칙
	  * 1. 재정의하는 선언부는 반드시 같아야 한다
	  * 2. 구현부는 달라야 한다.
	  * @override 어노테이션은 컴파일 타임에 메서드 재정의 규칙을 준수했는지를 체크해주는 역할이다.
	  * override - 상속 관계가 전제되어 있어햐 한다.
	  * */
	 @Override
	public String toString() {
		// super - 부모 클래스를 가리키는 keyword
		// return super.toString();
		
		// this - 자기 자신을 가리키는 keyword
		return this.message;
	}
	 
  }
