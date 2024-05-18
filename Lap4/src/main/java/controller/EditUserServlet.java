package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Department;
import model.BEAN.User;
import model.BO.UserBO;
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the id parameter
        String id = request.getParameter("id");
        System.out.println(id);
        User user = userBO.findById(Integer.parseInt(id));
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/EditUser.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		System.out.println(username);
        String password = request.getParameter("password");
        String idInfor = request.getParameter("idInfor");
        int idinfor = 0;
        if (!idInfor.equals("")) {
        	idinfor = Integer.parseInt(idInfor);
        }
        System.err.println(username);
        User user = new User(username,password,idinfor);
        user.setId(Integer.parseInt(id));
        userBO.updateUser(user);
        
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("role") != null) {
            String role = (String) session.getAttribute("role");
            if (role.equals("admin")) {
            	ArrayList<User> userarray = userBO.getAll();

                request.setAttribute("userarray", userarray);
         
                request.getRequestDispatcher("/ViewUserAdmin.jsp").forward(request, response);
            }
            else {
            	request.setAttribute("user", user);
                request.getRequestDispatcher("/EditUser.jsp").forward(request, response);
            }	
        }
	}
}
