package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUsingProps {

	public static void main(String[] args) {
		InputStream input = null;
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			input = new FileInputStream("db.properties");
			Properties prop = new Properties();
			prop.load(input);
			driver = prop.getProperty("db.driver");
			url=prop.getProperty("db.url");
			user=prop.getProperty("db.user");
			password=prop.getProperty("db.pass");
			sql = prop.getProperty("db.sql");
		}catch(IOException io) {
			io.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//1. Driver Class Loading
		try {
			Class.forName(driver);
			System.out.println("Driver Loading ����!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		try {
			//2. DB������ ���� Connection ��ü ����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection ��ü "  + conn.getClass().getName());
			//3. Sql���� �����ϴ� ������ �ϴ� Statement ��ü ����
			//Factory Method
			stmt = conn.createStatement();
			System.out.println("Statement ��ü " + stmt.getClass().getName());
			//4. Sql ���� �� ����
			rs = stmt.executeQuery(sql);
			System.out.println("ResultSet ��ü " + rs.getClass().getName());
			//ResultSetMetaData ��ü ����
			ResultSetMetaData md = rs.getMetaData();
			for(int i=1; i <= md.getColumnCount();i++)
				System.out.print(md.getColumnLabel(i) + " / ");
						
			//5. Query ��� ������ ó��
			while(rs.next()) {
				for(int i=1; i <= md.getColumnCount(); i++)
					System.out.print(rs.getString(i) + " ");
				System.out.println();
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
