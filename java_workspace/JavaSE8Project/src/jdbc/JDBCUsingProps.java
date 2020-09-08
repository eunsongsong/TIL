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
			System.out.println("Driver Loading 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		try {
			//2. DB연결을 위한 Connection 객체 생성
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 객체 "  + conn.getClass().getName());
			//3. Sql문을 전송하는 역할을 하는 Statement 객체 생성
			//Factory Method
			stmt = conn.createStatement();
			System.out.println("Statement 객체 " + stmt.getClass().getName());
			//4. Sql 전송 및 실행
			rs = stmt.executeQuery(sql);
			System.out.println("ResultSet 객체 " + rs.getClass().getName());
			//ResultSetMetaData 객체 생성
			ResultSetMetaData md = rs.getMetaData();
			for(int i=1; i <= md.getColumnCount();i++)
				System.out.print(md.getColumnLabel(i) + " / ");
						
			//5. Query 결과 데이터 처리
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
