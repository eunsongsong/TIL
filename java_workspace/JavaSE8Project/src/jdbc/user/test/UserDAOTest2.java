package jdbc.user.test;

import java.util.List;

import jdbc.UserVO;
import jdbc.user.dao.UserDAO2;

public class UserDAOTest2 {

	public static void main(String[] args) {
		UserDAO2 dao = new UserDAO2();

		// user 1�� ��ȸ
		UserVO user = dao.getUser("dooly");
		System.out.println(user);

//		// user ���
//		// ����� �Է� ���� UserVO ��ü�� ����
		UserVO insUser = new UserVO("spring", "��������Ʈ", "��", "����");
//		//
//		int cnt = (int) dao.insertUser(insUser);
//		System.out.println("\n��ϵ� �Ǽ�" + cnt);
		
		int cnt = dao.updateUser(insUser);
		System.out.println("���ŵ� �Ǽ� "+cnt);
		
		cnt = dao.deleteUser("spring");
		System.out.println("������ �Ǽ�"+cnt);
		
		// user ��ü ��ȸ
		System.out.println("\n== ��ü ����ڸ� ��ȸ�մϴ� ==");
		List<UserVO> userList = dao.getUsers();
		for (UserVO u : userList) {
			System.out.println(u);
		}

	}

}
