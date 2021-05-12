package usingServletJsp.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usingServletJsp.com.bean.Student;
import usingServletJsp.com.database.InsertStudentDao;
import usingServletJsp.com.database.StudentDao;

@WebServlet(urlPatterns = {"/insert"})
public class InsertStudentServlet extends HttpServlet {
	InsertStudentDao insertStudentDao;
	StudentDao studentDao;
	@Override
	public void init() throws ServletException {
		insertStudentDao = new InsertStudentDao();
		studentDao = new StudentDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int age = Integer.valueOf(req.getParameter("age"));
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		
		
		
		if(insertStudentDao.insertStudent(id, name, age, address, gender) == true) {
			RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
			List<Student> list;
			try {
				list = studentDao.getUserList();
				req.setAttribute("list", list);
				rd.forward(req, resp);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
