package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.dao.UserDao;
import myspring.user.dao.mapper.StudentMapper;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.DeptVO;
import myspring.user.vo.StudentVO;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class DataSourceTest {
	@Autowired
	DataSource dataSource;

	@Autowired
	SqlSessionFactory factory;

	@Autowired
	SqlSession session;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	StudentMapper stuMapper;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Test
	public void dao_service() {
		UserVO user = userDao.read("dooly");
		System.out.println(user);
		
		UserVO user2 = userService.getUser("dooly");
		System.out.println(user2);
		List<UserVO> userList = userService.getUserList();
		System.out.println(userList);
	}
	
	@Test @Ignore
	public void mapper() {
		StudentVO student = stuMapper.selectStudentById(1002);
		System.out.println(student);
		
		List<UserVO> userList = userMapper.selectUserList();
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}
	
	/*
	 <insert id="insertStudent" parameterType="Student">
		insert into student
		(stu_id,stu_name,stu_age,stu_grade,stu_daynight,dept_id)
		values(
		#{id},			//getID()
		#{name},		//getName()
		#{age},			//getAge()
		#{grade},		//getGrade()
		#{daynight},	//getDaynight()
		#{dept.deptid}	//getDept().getDeptid() 
		)
	</insert>
	 */
	
	@Test @Ignore
	public void students() {
		//new DeptVO(10);
//		DeptVO dept = new DeptVO();
//		dept.setDeptid(10);
		
		// insert
//		StudentVO student = new StudentVO(1003, "스프링학생", 21, "2학년", "야간", new DeptVO(10));
//		int cnt = session.insert("studentNS.insertStudent",student);
//		System.out.println("등록 건수 " + cnt);
		
		List<StudentVO> courseList = session.selectList("selectStudentCourseStatusById");
		for (StudentVO course : courseList) {
			System.out.println(course);
		}
		
		List<StudentVO> stuList = session.selectList("selectStudentDeptById");
		for (StudentVO studentVO : stuList) {
			System.out.println(studentVO);
		}
	}
	
	@Test @Ignore
	public void users() {
		System.out.println(session.getClass().getName());
		UserVO user = session.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
		
		UserVO user1 = new UserVO("spring", "스프링", "남", "서울");
//		int cnt = session.insert("userNS.insertUser", user1);
//		System.out.println("등록 건수 " + cnt);

//		int cntD = session.delete("userNS.deleteUser", "spring");
//		System.out.println("삭제 건수 " + cntD);
		
		UserVO user2 = new UserVO("dooly", "돌리", "남", "서울");
		int cntU = session.update("userNS.updateUser", user2);
		System.out.println("수정 건수 " + cntU);
		
		List<UserVO> userList = session.selectList("userNS.selectUserList");
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
	}

	@Test
	@Ignore
	public void con() {
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(factory.getClass().getName());
	}
}
