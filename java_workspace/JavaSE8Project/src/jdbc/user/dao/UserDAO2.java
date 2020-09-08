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

public class UserDAO2 {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";

	public UserDAO2() {
		// Driver Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading OK!!");
		} catch (ClassNotFoundException ex) {
			// ���� �޼��� ���
			System.out.println(ex.getMessage());
			// �޼��� ȣ�� ��ο� ���� �޼����� �Բ� ���
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

	// user ����
	public int deleteUser(String userid) {
		String sql = "delete from users where userid = ?";
		int delCnt = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, userid);
			delCnt = stmt.executeUpdate();
			close(stmt,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delCnt;
	}

	// user ���� ����
	public int updateUser(UserVO user) {
		String sql = "update users set NAME=?, GENDER=?, CITY=? where USERID=?";
		Connection connection = null;
		int updCnt = 0;
		try {
			connection = getConnection();
			// AutoCommit Mode off
			connection.setAutoCommit(false);

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(4, user.getUserId());
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getGender());
			stmt.setString(3, user.getCity());

			updCnt = stmt.executeUpdate();
			if (updCnt == 1) {
				connection.commit();
			} else {
				connection.rollback();
			}

			close(stmt, connection);
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return updCnt;
	}

	// user ���
	public Object insertUser(UserVO user) {
		String sql = "insert into users values (?,?,?,?)";
		Connection connection = null;
		int insCnt = 0;

		try {
			connection = getConnection();
			// AutoCommit Mode off
			connection.setAutoCommit(false);

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getGender());
			stmt.setString(4, user.getCity());

			insCnt = stmt.executeUpdate();

			if (insCnt == 1) {
				connection.commit();
			} else {
				connection.rollback();
			}

			close(stmt, connection);

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return insCnt;

	}

	// user ��ü ��ȸ
	public List<UserVO> getUsers() {
		String sql = "select * from users order by userid";
		UserVO user = null;
		List<UserVO> userList = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Row data�� UserVO object�� ���� - ������ �÷��� ���� UserVO object�� ��������� ����
				user = new UserVO(rs.getString("userid"), rs.getString("name"), rs.getString("gender"),
						rs.getString("city"));
				// ���� ���� UserVO ��ü�� �÷��ǿ� ����
				userList.add(user);
			}

			close(stmt, connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	// user 1�� ��ȸ
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
