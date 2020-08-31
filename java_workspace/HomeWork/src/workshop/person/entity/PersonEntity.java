package workshop.person.entity;

public class PersonEntity {
	// private로 멤버 변수 선언
	private String name;
	private char gender = '남';
	private String ssn;
	private String address;
	private String phone;
	
	// 각각의 멤버변수들과 관련있는 setter 메서드를 사용하여 해당 멤버변수들을 초기화하는 생성자
	public PersonEntity(String name, String ssn, String address, String phone ) {
		setName(name);
		setSsn(ssn);
		setAddress(address);
		setPhone(phone);
	}

	/* 각각 멤버 변수들의 getter, setter 메서드 */
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

	// 주민등록번호 7번째 글자를 판별하여 멤버변수 gender 값을 변경한다.
	public void setSsn(String ssn) {
		this.ssn = ssn;
		if(ssn.charAt(6)=='2'||ssn.charAt(6)=='4') {
			this.gender = '여';
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
