package jdbc.user.test;

import java.util.List;
import java.util.Scanner;

import jdbc.UserVO;
import jdbc.user.dao.UserDAO;

public class UserDAOTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		// user 1명 조회
//		Scanner scanner = new Scanner(System.in);
//		System.out.println(">> 조회할 아이디를 입력하세요");
//		String IdValue = scanner.next();
//		UserVO user = dao.getUser(IdValue);
		UserVO user = dao.getUser("dooly");
		System.out.println(user);
		
		// user 등록
//		System.out.println("\n>> 등록할 아이디를 입력하세요");
//		String insertId = scanner.next();
//		System.out.println(">> 등록할 이름을 입력하세요");
//		String insertName = scanner.next();
//		System.out.println(">> 등록할 성별을 입력하세요");
//		String insertGender = scanner.next();
//		System.out.println(">> 등록할 도시를 입력하세요");
//		String insertCity = scanner.next();
//		UserVO u = new UserVO(insertId,insertName,insertGender,insertCity);
		UserVO u = new UserVO("yum","유미","여","서울");
		dao.insertUser(u);
		
		// user 전체 조회
		System.out.println("\n== 전체 사용자를 조회합니다 ==");
		List<UserVO> userList = dao.getUsers();
		System.out.println(userList);
//		scanner.close();
	}

}
