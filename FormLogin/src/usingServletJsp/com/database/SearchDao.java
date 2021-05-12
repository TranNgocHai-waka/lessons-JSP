package usingServletJsp.com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usingServletJsp.com.bean.Student;
import usingServletJsp.com.connection.ConnectionUtil;

public class SearchDao {
	Connection conn = null;
	public  List<Student> getUserList(String age, String name, String id, String address, String gender) throws SQLException, ClassNotFoundException {
		List<Student> list = new ArrayList<Student>();
		conn = ConnectionUtil.getConnection();
		
		StringBuilder sql = new StringBuilder( "select * from Student where 1=1 ");
		List<Object> listValue = new ArrayList<Object>();
		
		if( age != null && !"".equals(age)) {
			if(Integer.valueOf(age) > 0) {
				sql.append(" AND Age = ?");
				listValue.add(age);
			}
		}
		if(name!=null && !"".equals(name)) {
			sql.append(" AND Name = ?");
			listValue.add(name);	
		}
		
		if(id!=null && !"".equals(id)) {
			sql.append(" AND StudentId = ?");
			listValue.add(id);	
		}
		
		if(address!= null && !"".equals(address)) {
			sql.append(" AND Address = ?");
			listValue.add(address);	
		}
		
		if(gender != null && !"".equals(gender)) {
			sql.append(" AND Gender = ?");
			listValue.add(gender);	
		}
		
		try {
			PreparedStatement pre = conn.prepareStatement(sql.toString());
			for(int i=0; i<listValue.size(); i++) {
				pre.setObject(i+1, listValue.get(i));
			}
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("StudentId"));
				student.setName(rs.getString("Name"));
				student.setAge(rs.getInt("Age"));
				student.setAddress(rs.getString("Address"));
				student.setGender(rs.getString("Gender"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
