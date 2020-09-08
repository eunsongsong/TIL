package jdbc.user.test;

import java.util.List;
import java.util.Scanner;

import jdbc.UserVO;
import jdbc.user.dao.UserDAO;

public class UserDAOTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// user 1�� ��ȸ
//		Scanner scanner = new Scanner(System.in);
//		System.out.println(">> ��ȸ�� ���̵� �Է��ϼ���");
//		String IdValue = scanner.next();
//		UserVO user = dao.getUser(IdValue);
		UserVO user = dao.getUser("dooly");
		System.out.println(user);
		
		// user ���
//		System.out.println("\n>> ����� ���̵� �Է��ϼ���");
//		String insertId = scanner.next();
//		System.out.println(">> ����� �̸��� �Է��ϼ���");
//		String insertName = scanner.next();
//		System.out.println(">> ����� ������ �Է��ϼ���");
//		String insertGender = scanner.next();
//		System.out.println(">> ����� ���ø� �Է��ϼ���");
//		String insertCity = scanner.next();
//		UserVO insertU = new UserVO(insertId,insertName,insertGender,insertCity);
//		UserVO insertU = new UserVO("yum","����","��","�ϻ�");
//		dao.insertUser(insertU);
		
		// user ���� ����
		UserVO updateU = new UserVO("giant","�α�","��","��õ");
		dao.updateUser(updateU);
		
		// user ����
		dao.deleteUser("yum");
		
		
		// user ��ü ��ȸ
		System.out.println("\n== ��ü ����ڸ� ��ȸ�մϴ� ==");
		List<UserVO> userList = dao.getUsers();
		for(UserVO userVO : userList) {
			System.out.println(userVO);			
		}
//		scanner.close();
	}

}
