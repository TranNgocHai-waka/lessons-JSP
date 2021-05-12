package usingServletJsp.com.database;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import usingServletJsp.com.bean.Student;
import usingServletJsp.com.connection.ConnectionUtil;

public class InsertStudentDao {
	public Connection conn = null;
	
	
	
	public boolean insertStudent(String id, String name, int age, String address, String gender) {
		conn = ConnectionUtil.getConnection();
		
		String sql = "insert into Student values(?,?,?,?,?)";
		
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			
			pre.setString(1, id);
			pre.setString(2, name);
			pre.setInt(3, age);
			pre.setString(4, address);
			pre.setString(5, gender);
			
			pre.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
