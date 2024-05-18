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

@WebServlet("/deleteStaff")
public class DeleteStaffServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffBO staffBO = new StaffBO();
	private DepartmentBO departmentBO = new DepartmentBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
        String id = request.getParameter("id");
        
        // Process the id as needed (e.g., delete the department from the database)
        staffBO.deleteStaff(Integer.parseInt(id));
        // Redirect to a confirmation page or back to the departments list
        ArrayList<Staff> staffarray = staffBO.getAll();
        request.setAttribute("staffarray", staffarray);
        ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/ViewStaff.jsp").forward(request, response);
    }
}
