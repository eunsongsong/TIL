package workshop.book.control;

import java.util.Scanner;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		Publication[] publication = new Publication[5];
		publication[0] = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		publication[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		publication[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		publication[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		publication[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");

		System.out.println("==== Book 정보 출력 ====");
		for (Publication p : publication) {
			System.out.println(p.toString());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println(">> 조회할 책 번호 입력");
		int value = scanner.nextInt();
		modifyPrice(publication[value-1]);
		scanner.close();

	}

	private static void modifyPrice(Publication p) {
		System.out.println("==== 가격정보 변경 전 ====");
		System.out.println(p.toString() + " : " + p.getPrice());
		System.out.println("==== 가격정보 변경 후 ====");
		System.out.print(p.toString() + " : ");
		if (p instanceof Magazine) {
			System.out.println((int) (p.getPrice() * 0.6));
		} else if (p instanceof Novel) {
			System.out.println((int) (p.getPrice() * 0.8));
		} else if (p instanceof ReferenceBook) {
			System.out.println((int) (p.getPrice() * 0.9));
		} else {
			System.out.println("가격 변동 없음");
		}
	}

}
