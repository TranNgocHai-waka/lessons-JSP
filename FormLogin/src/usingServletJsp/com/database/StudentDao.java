package usingServletJsp.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import usingServletJsp.com.bean.LoginBean;
import usingServletJsp.com.bean.Student;
import usingServletJsp.com.connection.ConnectionUtil;

public class StudentDao {
	Connection conn = null;
	
	public  List<Student> getUserList() throws SQLException, ClassNotFoundException {
	
		conn = ConnectionUtil.getConnection();
		
		String sql = "select StudentId, Name, Age, Address, Gender from Student";
		
		PreparedStatement pre = conn.prepareStatement(sql);
		
		ResultSet rs = pre.executeQuery();
		
		List<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student student = new Student();
			student.setId(rs.getString("StudentId"));
			student.setName(rs.getString("Name"));
			student.setAge(rs.getInt("Age"));
			student.setAddress(rs.getString("Address"));
			student.setGender(rs.getString("Gender"));
			list.add(student);
		}
	return list;
	}
	
}
