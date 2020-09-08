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
		// try ~ catch ���� ����
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loading OK!!");
		} catch (ClassNotFoundException ex) {
			// ���� �޼��� ���
			System.out.println(ex.getMessage());
			// �޼��� ȣ�� ��ο� ���� �޼����� �Բ� ���
			ex.printStackTrace();
		}

		// try ~ catch : ������ �� �Ŀ��� �� ���� ������ ���������� ����
		System.out.println("2. Connection ����");

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

			System.out.println("3. Statement ����");
			stmt = conn.createStatement();
			System.out.println(stmt.getClass().getName());

			System.out.println("4. ResultSet ���� - SELECT SQL ����");
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