package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Department;
import model.BEAN.Staff;
import model.BO.DepartmentBO;
import model.BO.StaffBO;
@WebServlet("/addStaff")
public class AddStaffServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffBO staffBO = new StaffBO();
	private DepartmentBO departmentBO = new DepartmentBO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Staff> staffarray = staffBO.getAll();
		ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("staffarray", staffarray);
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/ViewStaff.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		Staff staff = new Staff(idDepartment, name, address, gender, phone);
		staffBO.addStaff(staff);
		System.out.println(staff.getName());
		ArrayList<Staff> staffarray = staffBO.getAll();
		ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("staffarray", staffarray);
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/ViewStaff.jsp").forward(request, response);
	}
}
