package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Department;
import model.BEAN.Staff;
import model.BO.DepartmentBO;
import model.BO.StaffBO;

@WebServlet("/viewDepartment")
public class ViewDepartmentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StaffBO staffBO = new StaffBO();
	private DepartmentBO departmentBO = new DepartmentBO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
    	String destination = "";
        String id = request.getParameter("id");
        ArrayList<Staff> listStaff = staffBO.findByIdDepartment(Integer.parseInt(id));
        // Process the id as needed (e.g., fetch department details from database)
        request.setAttribute("staffarray", listStaff);
        // Forward to a JSP page to display the department details
//        request.getRequestDispatcher("/viewDepartment.jsp").forward(request, response);
        ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        destination = "/ViewStaff.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
    }
}
