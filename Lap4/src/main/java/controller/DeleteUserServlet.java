package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.User;
import model.BO.UserBO;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
        String id = request.getParameter("id");
        
        // Process the id as needed (e.g., delete the department from the database)
        userBO.deleteUser(Integer.parseInt(id));
        // Redirect to a confirmation page or back to the departments list
        ArrayList<User> userarray = userBO.getAll();

        request.setAttribute("userarray", userarray);
 
        request.getRequestDispatcher("/ViewUserAdmin.jsp").forward(request, response);
    }
}
