package workshop.person.control;


import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManager {

	public static void main(String[] args) {
		// main() 메서드는 static 메서드 이므로 static이 아닌 메서드를 사용하기 위해 객체를 생성한다. 
		PersonManager pManager = new PersonManager();
		// 타이틀을 출력한다.
		pManager.printTitle("인물 정보 조회 시스템");
		pManager.printTitleLine();
		// PersonEntity 배열을 선언한다.
		PersonEntity[] persons = new PersonEntity[10];
		// persons에 정보를 set 한다. 
		pManager.fillPersons(persons);
		// 전체 persons 정보를 display 한다. 
		pManager.showPerson(persons);
		
		// 성별 입력받기(char타입 입력받기)
		Scanner scanner = new Scanner(System.in);
		System.out.println(">> 성별을 입력하세요");
		char genderValue = scanner.next().charAt(0);
		// persons 객체 정보 중 해당 gender 의 인원수를 return 받는다.
		pManager.findByGender(persons, genderValue);
		pManager.printTitleLine();
		
		// 이름 입력받기
		System.out.println(">> 이름을 임력하세요");
		String nameValue = scanner.next();
		// 특정 person의 상세정보를 display 한다.
		pManager.showPerson(persons, nameValue);
		scanner.close();

	}

	// PersonEntity[]의 정보를 set 하는 메서드 
	public void fillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("이성호", "7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘", "7302132363217", "서울 강동구", "02-362-1932");
		persons[2] = new PersonEntity("박영수", "7503111233201", "서울 성북구", "02-887-1542");
		persons[3] = new PersonEntity("나인수", "7312041038988", "대전 유성구", "032-384-2223");
		persons[4] = new PersonEntity("홍정수", "7606221021341", "서울 양천구", "02-158-7333");
		persons[5] = new PersonEntity("이미숙", "7502142021321", "서울 강서구", "02-323-1934");
		persons[6] = new PersonEntity("박성구", "7402061023101", "서울 종로구", "02-308-0932");
		persons[7] = new PersonEntity("유성미", "7103282025101", "서울 은평구", "02-452-0939");
		persons[8] = new PersonEntity("황재현", "7806231031101", "인천 중구", "032-327-2202");
		persons[9] = new PersonEntity("최철수", "7601211025101", "인천 계양구", "032-122-7832");
	}

	// PersonEntity[]의 정보를 출력하는 메서드
	public void showPerson(PersonEntity[] persons) {
		for (PersonEntity p : persons) {
			System.out.println("[이름] " + p.getName() + "\t[성별] " + p.getGender() + "\t\t[전화번호] " + p.getPhone());
			printItemLine();
		}
	}
	
	// PersonEntity[]의 정보 중 아규먼트로 넘어온 gender에 해당하는 인원수를 return하는 메서드
	public void findByGender(PersonEntity[] persons, char gender) {
		int count = 0;
		for (PersonEntity p : persons) {
			if (p.getGender() == gender) {
				count++;
			}
		}	
		System.out.println("성별 : '"+gender+"'(은)는 "+count+"명 입니다.");	
	}
	
	// PersonEntity[]의 정보 중 아규먼트의 name과 일치 하는 person의 상세정보를 보여주는 메서드
	public void showPerson(PersonEntity[]persons, String name) {
		for (PersonEntity p : persons) {
			if(p.getName().equals(name)) {
				System.out.println("-- 이름 : '"+name+"'(으)로 찾기 결과입니다. --");
				printItemLine();
				System.out.println("[이름] "+name);
				System.out.println("[성별] "+p.getGender());
				System.out.println("[전화번호] "+p.getPhone());
				System.out.println("[주소] "+p.getAddress());
				break;
			}
		}
	}
	
	// Title을 출력하는 메세드 
	public void printTitle(String Title) {
		System.out.println("@@@ " + Title + " @@@" );
	}
	
	// 이중선(=)을 출력하는 메서드
	public void printTitleLine() {
		String titleLine = "=";
		System.out.println(titleLine.repeat(60));
	}
	
	// 선(-)을 출력하는 메서드
	public void printItemLine() {
		String itemLine = "-";
		System.out.println(itemLine.repeat(60));
	}

}
