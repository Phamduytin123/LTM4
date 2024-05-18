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

@WebServlet("/editStaff")
public class EditStaffServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffBO staffBO = new StaffBO();
	private DepartmentBO departmentBO = new DepartmentBO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
	
        String id = request.getParameter("id");
        System.out.println(id);
        Staff staff = staffBO.findById(Integer.parseInt(id));
        ArrayList<Department> departmentarray = departmentBO.getAll();

        request.setAttribute("staff", staff);
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/EditStaff.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idDepartment = Integer.parseInt(request.getParameter("idDepartment"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		Staff staff = new Staff(idDepartment, name, address, gender, phone);
		staff.setId(id);
		staffBO.updateStaff(staff);
		System.out.println(id);
		ArrayList<Staff> staffarray = staffBO.getAll();
		ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("staffarray", staffarray);
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/ViewStaff.jsp").forward(request, response);
	}
}
