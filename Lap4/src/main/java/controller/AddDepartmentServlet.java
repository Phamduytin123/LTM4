package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Department;
import model.BO.DepartmentBO;
@WebServlet("/addDepartment")
public class AddDepartmentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1373621932102737531L;
	private DepartmentBO departmentBO = new DepartmentBO();
	public AddDepartmentServlet() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/WelcomeAdmin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String destination = "";
		String name = request.getParameter("name");
		System.out.println(name);
        String description = request.getParameter("description");
        Department department = new Department(name,description);
        departmentBO.addDepartment(department);
        
        ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/WelcomeAdmin.jsp").forward(request, response);
	}
}
