package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import model.BEAN.Department;
import model.BEAN.User;
import model.BO.DepartmentBO;
import model.BO.UserBO;

@WebServlet("/CheckLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBO userBO = new UserBO();
    private DepartmentBO departmentBO = new DepartmentBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		String destination = null;
		ArrayList<Department> departmentarray = null;
		departmentarray = departmentBO.getAll();
		request.setAttribute("departmentarray", departmentarray);
		destination = "/WelcomeAdmin.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if(userBO.isValidUser(username, password)) {
				HttpSession session = request.getSession();
	            
				if (username.equals("admin")) {
					ArrayList<Department> departmentarray = null;
					departmentarray = departmentBO.getAll();
					request.setAttribute("departmentarray", departmentarray);
					destination = "/WelcomeAdmin.jsp";
					session.setAttribute("role", "admin");
				} else {
					User user = userBO.findUser(username, password);
					request.setAttribute("user", user);
					destination = "/EditUser.jsp";
					session.setAttribute("role", "user");
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else
			{
				destination = "/login.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}catch ( IOException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
