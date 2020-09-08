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
//		UserVO insertU = new UserVO(insertId,insertName,insertGender,insertCity);
//		UserVO insertU = new UserVO("yum","유미","여","일산");
//		dao.insertUser(insertU);
		
		// user 정보 수정
		UserVO updateU = new UserVO("giant","핑구","남","인천");
		dao.updateUser(updateU);
		
		// user 삭제
		dao.deleteUser("yum");
		
		
		// user 전체 조회
		System.out.println("\n== 전체 사용자를 조회합니다 ==");
		List<UserVO> userList = dao.getUsers();
		for(UserVO userVO : userList) {
			System.out.println(userVO);			
		}
//		scanner.close();
	}

}
