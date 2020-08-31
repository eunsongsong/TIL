package workshop.person.entity;

public class PersonEntity {
	// private�� ��� ���� ����
	private String name;
	private char gender = '��';
	private String ssn;
	private String address;
	private String phone;
	
	// ������ ���������� �����ִ� setter �޼��带 ����Ͽ� �ش� ����������� �ʱ�ȭ�ϴ� ������
	public PersonEntity(String name, String ssn, String address, String phone ) {
		setName(name);
		setSsn(ssn);
		setAddress(address);
		setPhone(phone);
	}

	/* ���� ��� �������� getter, setter �޼��� */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	// �ֹε�Ϲ�ȣ 7��° ���ڸ� �Ǻ��Ͽ� ������� gender ���� �����Ѵ�.
	public void setSsn(String ssn) {
		this.ssn = ssn;
		if(ssn.charAt(6)=='2'||ssn.charAt(6)=='4') {
			this.gender = '��';
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
