package usingServletJsp.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import usingServletJsp.com.bean.LoginBean;
import usingServletJsp.com.connection.ConnectionUtil;

public class LoginDao {
	public boolean validate(LoginBean loginBean) throws SQLException {
		boolean isValidate = false;
		Connection conn = null;
		
		conn = ConnectionUtil.getConnection();
		
		String sql = "select * from account where username = ? and password = ?";
			
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, loginBean.getUsername());
		pre.setString(2, loginBean.getPassword());
			
		ResultSet rs = pre.executeQuery();
			
		if(rs.next()) {
			isValidate = true;
		} else {
			isValidate = false;
		}
			
	return isValidate;
	
	}
}
