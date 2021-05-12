package usingServletJsp.com.web;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import usingServletJsp.com.bean.Student;
import usingServletJsp.com.connection.ConnectionUtil;
import usingServletJsp.com.database.SearchDao;

@WebServlet(urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
	SearchDao searchDao;
	@Override
	public void init() throws ServletException {
		searchDao = new SearchDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String age = null;
		String name = null, id = null, address = null, gender = null;
		List<Student> list;
			try {
				age = req.getParameter("age");
				name = req.getParameter("name");
				id = req.getParameter("id");
				address = req.getParameter("address");
				gender = req.getParameter("gender");
				//validate
				if(!"".equals(age))
					Integer.valueOf(age);
				
				list = searchDao.getUserList(age,name,id,address,gender);
				req.setAttribute("list", list);
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				rd.forward(req, resp);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				req.setAttribute("errorMsg", "Age invalid!");
				rd.forward(req, resp);
				//input error
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		
	}
	
}
