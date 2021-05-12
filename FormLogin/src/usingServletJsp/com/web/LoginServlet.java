package usingServletJsp.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usingServletJsp.com.bean.LoginBean;
import usingServletJsp.com.bean.Student;
import usingServletJsp.com.database.LoginDao;
import usingServletJsp.com.database.StudentDao;

@WebServlet(urlPatterns = {"/check"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    private StudentDao studentDao;
	@Override
	public void init() throws ServletException {
		loginDao = new LoginDao();
		studentDao = new StudentDao();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("txtusername");
		String password = req.getParameter("txtpassword");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPasswordString(password);
		
		
		try {
			if(loginDao.validate(loginBean)==true) {
				RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
				List<Student> list = studentDao.getUserList();
				req.setAttribute("list", list);
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("login1.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
