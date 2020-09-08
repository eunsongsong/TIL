package jdbc.user.test;

import java.util.List;

import jdbc.UserVO;
import jdbc.user.dao.UserDAO2;

public class UserDAOTest2 {

	public static void main(String[] args) {
		UserDAO2 dao = new UserDAO2();

		// user 1명 조회
		UserVO user = dao.getUser("dooly");
		System.out.println(user);

//		// user 등록
//		// 등록할 입력 값을 UserVO 객체에 저장
		UserVO insUser = new UserVO("spring", "스프링부트", "여", "제주");
//		//
//		int cnt = (int) dao.insertUser(insUser);
//		System.out.println("\n등록된 건수" + cnt);
		
		int cnt = dao.updateUser(insUser);
		System.out.println("갱신된 건수 "+cnt);
		
		cnt = dao.deleteUser("spring");
		System.out.println("삭제된 건수"+cnt);
		
		// user 전체 조회
		System.out.println("\n== 전체 사용자를 조회합니다 ==");
		List<UserVO> userList = dao.getUsers();
		for (UserVO u : userList) {
			System.out.println(u);
		}

	}

}
