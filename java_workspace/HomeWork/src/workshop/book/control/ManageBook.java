package workshop.book.control;

import java.util.Scanner;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		Publication[] publication = new Publication[5];
		publication[0] = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
		publication[1] = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
		publication[2] = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
		publication[3] = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
		publication[4] = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");

		System.out.println("==== Book ���� ��� ====");
		for (Publication p : publication) {
			System.out.println(p.toString());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println(">> ��ȸ�� å ��ȣ �Է�");
		int value = scanner.nextInt();
		modifyPrice(publication[value-1]);

	}

	private static void modifyPrice(Publication p) {
		System.out.println("==== �������� ���� �� ====");
		System.out.println(p.toString() + " : " + p.getPrice());
		System.out.println("==== �������� ���� �� ====");
		System.out.print(p.toString() + " : ");
		if (p instanceof Magazine) {
			System.out.println((int) (p.getPrice() * 0.6));
		} else if (p instanceof Novel) {
			System.out.println((int) (p.getPrice() * 0.8));
		} else if (p instanceof ReferenceBook) {
			System.out.println((int) (p.getPrice() * 0.9));
		} else {
			System.out.println("���� ���� ����");
		}
	}

}
