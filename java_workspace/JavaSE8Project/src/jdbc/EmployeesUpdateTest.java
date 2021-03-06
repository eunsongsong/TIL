package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesUpdateTest {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "hr";
	String password = "hr";

	public EmployeesUpdateTest() {

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

	public int updateEmployee(float salary, String email) {
		int rowCount = 0;
//		String sql = "update EMPLOYEES set SALARY = 7000 where EMAIL = 'DLEE'";
		StringBuilder builder = new StringBuilder("update EMPLOYEES set SALARY = " + salary)
				.append("where EMAIL = '" + email + "'");
		String sql = builder.toString();
		System.out.println(sql);

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			rowCount = stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery("select * from employees where EMAIL ='" + email + "'");
			if (rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("email"));
			}
			close(stmt, con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	public static void main(String[] args) {
		EmployeesUpdateTest test = new EmployeesUpdateTest();

		float salary = 6800.0F;
		String email = "DLEE";

		int cnt = test.updateEmployee(salary, email);
		System.out.println("업데이트 된 Row 건수 " + cnt);
	}

}
