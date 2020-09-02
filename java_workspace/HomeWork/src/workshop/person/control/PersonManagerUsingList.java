package workshop.person.control;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManagerUsingList {

	public static void main(String[] args) {
		// main() �޼���� static �޼��� �̹Ƿ� static�� �ƴ� �޼��带 ����ϱ� ���� ��ü�� �����Ѵ�. 
		PersonManagerUsingList pManager = new PersonManagerUsingList();
		// Ÿ��Ʋ�� ����Ѵ�.
		pManager.printTitle("�ι� ���� ��ȸ �ý���");
		pManager.printTitleLine();
		// PersonEntity �迭�� �����Ѵ�.
//		PersonEntity[] persons = new PersonEntity[10];
		List<PersonEntity> persons = new ArrayList<PersonEntity>();
		// persons�� ������ set �Ѵ�. 
		pManager.fillPersons(persons);
		// ��ü persons ������ display �Ѵ�. 
		pManager.showPerson(persons);
		
		// ���� �Է¹ޱ�(charŸ�� �Է¹ޱ�)
		Scanner scanner = new Scanner(System.in);
		System.out.println(">> ������ �Է��ϼ���(��/��)");
		char genderValue = scanner.next().charAt(0);
		// persons ��ü ���� �� �ش� gender �� �ο����� return �޴´�.
		pManager.findByGender(persons, genderValue);
		pManager.printTitleLine();
		
		// �̸� �Է¹ޱ�
		System.out.println(">> �̸��� �ӷ��ϼ���");
		String nameValue = scanner.next();
		// Ư�� person�� �������� display �Ѵ�.
		pManager.showPerson(persons, nameValue);
		scanner.close();

	}

	// PersonEntity[]�� ������ set �ϴ� �޼��� 
	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932"));
		persons.add(new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932"));
		persons.add(new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333"));
		persons.add(new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223"));
		persons.add(new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934"));
		persons.add(new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932"));
		persons.add(new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542"));
		persons.add(new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939"));
		persons.add(new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202"));
		persons.add(new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832"));
	}

	// PersonEntity[]�� ������ ����ϴ� �޼���
	public void showPerson(List<PersonEntity> persons) {
		for (PersonEntity p : persons) {
			System.out.println("[�̸�] " + p.getName() + "\t[����] " + p.getGender() + "\t\t[��ȭ��ȣ] " + p.getPhone());
			printItemLine();
		}
	}
	
	// PersonEntity[]�� ���� �� �ƱԸ�Ʈ�� �Ѿ�� gender�� �ش��ϴ� �ο����� return�ϴ� �޼���
	public void findByGender(List<PersonEntity> persons, char gender) {
		int count = 0;
		for (PersonEntity p : persons) {
			if (p.getGender() == gender) {
				count++;
			}
		}	
		System.out.println("���� : '"+gender+"'(��)�� "+count+"�� �Դϴ�.");	
	}
	
	// PersonEntity[]�� ���� �� �ƱԸ�Ʈ�� name�� ��ġ �ϴ� person�� �������� �����ִ� �޼���
	public void showPerson(List<PersonEntity> persons, String name) {
		for (PersonEntity p : persons) {
			if(p.getName().equals(name)) {
				System.out.println("-- �̸� : '"+name+"'(��)�� ã�� ����Դϴ�. --");
				printItemLine();
				System.out.println("[�̸�] "+name);
				System.out.println("[����] "+p.getGender());
				System.out.println("[��ȭ��ȣ] "+p.getPhone());
				System.out.println("[�ּ�] "+p.getAddress());
				break;
			}
		}
	}
	
	// Title�� ����ϴ� �޼��� 
	public void printTitle(String Title) {
		System.out.println("@@@ " + Title + " @@@" );
	}
	
	// ���߼�(=)�� ����ϴ� �޼���
	public void printTitleLine() {
		String titleLine = "=";
		System.out.println(titleLine.repeat(60));
	}
	
	// ��(-)�� ����ϴ� �޼���
	public void printItemLine() {
		String itemLine = "-";
		System.out.println(itemLine.repeat(60));
	}

}