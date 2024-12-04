package org.web.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	//Connection pool 사용
			public static Connection getConnection() {
				
				Connection conn=null;
				
//				String driver="oracle.jdbc.driver.OracleDriver";
//				String url="jdbc:oracle:thin:@localhost:1521:xe";
//				String user="system";
//				String password="1234";
				
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/springdb1";
				String user="root";
				String password="1234";
				
				try {
					Class.forName(driver);
					System.out.println("드라이버연결 성공");
					conn=DriverManager.getConnection(url, user, password);
					System.out.println("DB연결 성공");
					
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("드라이버 연결 실패");
				}catch(SQLException e) {
					e.printStackTrace();
					System.out.println("DB연결 실패");
				}
				

				return conn;
			}
}
