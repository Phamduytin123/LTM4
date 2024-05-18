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
@WebServlet("/deleteDepartment")
public class DeleteDepartmentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DepartmentBO departmentBO = new DepartmentBO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
        String id = request.getParameter("id");
        
        // Process the id as needed (e.g., delete the department from the database)
        departmentBO.deleteDepartment(Integer.parseInt(id));
        // Redirect to a confirmation page or back to the departments list
        ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/WelcomeAdmin.jsp").forward(request, response);
    }
}
