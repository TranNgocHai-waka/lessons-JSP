package usingServletJsp.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionURL = "jdbc:sqlserver://DESKTOP-5BBRVNO:1433; databaseName =QuanLyLogin; user=sa; password= 123456790 ";
			
			conn =  DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
