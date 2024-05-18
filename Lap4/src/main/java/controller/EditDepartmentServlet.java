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
@WebServlet("/editDepartment")
public class EditDepartmentServlet extends HttpServlet {
	private DepartmentBO departmentBO = new DepartmentBO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
        String id = request.getParameter("id");
        
        Department department = departmentBO.findById(Integer.parseInt(id));

        request.setAttribute("department", department);
        request.getRequestDispatcher("/editDepartment.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Department department = new Department(name,description);
        department.setId(id);
        departmentBO.updateDepartment(department);
        // Update the department in the database
        // Example: updateDepartment(id, name, description);

        // Redirect to a confirmation page or back to the department list
        ArrayList<Department> departmentarray = departmentBO.getAll();
        request.setAttribute("departmentarray", departmentarray);
        request.getRequestDispatcher("/WelcomeAdmin.jsp").forward(request, response);
    }
}