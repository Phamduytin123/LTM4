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
import model.BEAN.User;
import model.BO.UserBO;
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBO userBO = new UserBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> userarray = userBO.getAll();

        request.setAttribute("userarray", userarray);
 
        request.getRequestDispatcher("/ViewUserAdmin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        userBO.addUser(user);
        
        ArrayList<User> userarray = userBO.getAll();

        request.setAttribute("userarray", userarray);
 
        request.getRequestDispatcher("/ViewUserAdmin.jsp").forward(request, response);
	}
}
