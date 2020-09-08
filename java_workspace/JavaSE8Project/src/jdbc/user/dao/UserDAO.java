package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.UserVO;

public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";

	public UserDAO() {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading OK!!");
		} catch (ClassNotFoundException ex) {
			// 오류 메세지 출력
			System.out.println(ex.getMessage());
			// 메서드 호출 경로와 오류 메세지를 함께 출력
			ex.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void close(Statement stmt, Connection con) throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

	// user 삭제
	public int deleteUser(String userid) {
		String sql = "delete from users where userid = ?";
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.executeUpdate();
			
			close(stmt,connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// user 정보 수정
	public int updateUser(UserVO user) {
		String sql = "update users set NAME=?, GENDER=?, CITY=? where USERID=?";
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(4, user.getUserId());
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getGender());
			stmt.setString(3, user.getCity());
			stmt.executeUpdate();
			close(stmt, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// user 등록
	public Object insertUser(UserVO user) {
		StringBuilder builder = new StringBuilder("insert into users values ('" + user.getUserId() + "','"
				+ user.getName() + "','" + user.getGender() + "','" + user.getCity() + "')");
		String sql = builder.toString();
		UserVO addUser = null;

		try {
			Connection connection = getConnection();
//			Statement stmt = connection.createStatement();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.toString();
			stmt.executeQuery(sql);

			close(stmt, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addUser;

	}

	// user 전체 조회
	public List<UserVO> getUsers() {
		String sql = "select * from users";
		List<UserVO> userList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.toString();

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				userList.add(new UserVO(rs.getString("userid"), rs.getString("name"), rs.getString("gender"),
						rs.getString("city")));
			}
			close(stmt, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	// user 1명 조회
	public UserVO getUser(String userid) {
		String sql = "select * from users where userid = ?";
		UserVO user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new UserVO(rs.getString("userid"), rs.getString("name"), rs.getString("gender"),
						rs.getString("city"));
			}
			close(stmt, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	} // getUser

}
