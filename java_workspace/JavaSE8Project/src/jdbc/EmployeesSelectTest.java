package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesSelectTest {

	public static void main(String[] args) {
		// 1. Driver Class Loading
		// Unhandled exception type ClassNotFoundException
		// try ~ catch 구문 선언
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading OK!!");
		} catch (ClassNotFoundException ex) {
			// 오류 메세지 출력
			System.out.println(ex.getMessage());
			// 메서드 호출 경로와 오류 메세지를 함께 출력
			ex.printStackTrace();
		}

		// try ~ catch : 오류가 난 후에도 그 다음 동작을 정상적으로 실행
		System.out.println("2. Connection 생성");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = "select * from employees";

		Connection conn = null;
		Statement stmt = null;

		// Unhandled exception type SQLException
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn.getClass().getName());

			System.out.println("3. Statement 생성");
			stmt = conn.createStatement();
			System.out.println(stmt.getClass().getName());

			System.out.println("4. ResultSet 생성 - SELECT SQL 실행");
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getClass().getName());
//			stmt.executeQuery(sql);

			/*
			 * EMPLOYEE_ID NOT NULL NUMBER(6) FIRST_NAME VARCHAR2(20) LAST_NAME NOT NULL
			 * VARCHAR2(25) EMAIL NOT NULL VARCHAR2(25) PHONE_NUMBER VARCHAR2(20) HIRE_DATE
			 * NOT NULL DATE JOB_ID NOT NULL VARCHAR2(10) SALARY NUMBER(8,2) COMMISSION_PCT
			 * NUMBER(2,2) MANAGER_ID NUMBER(6) DEPARTMENT_ID NUMBER(4)
			 */

			while (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String name = rs.getString("FIRST_NAME");
				Date hDate = rs.getDate(6);
				float sal = rs.getFloat("SALARY");
				System.out.println(id + " " + name + " " + hDate + " " + sal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
