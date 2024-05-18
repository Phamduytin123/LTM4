package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Staff;
import model.BEAN.User;
import model.BO.UserBO;

@WebServlet("/viewUser")
public class ViewUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
    	String destination = "";
        String id = request.getParameter("id");
        User user = userBO.findByIdInfor(Integer.parseInt(id));
        // Process the id as needed (e.g., fetch department details from database)
        request.setAttribute("user", user);
        // Forward to a JSP page to display the department details
//        request.getRequestDispatcher("/viewDepartment.jsp").forward(request, response);
        destination = "/ViewUser.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
    }
}
