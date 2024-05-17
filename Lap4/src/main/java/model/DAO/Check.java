package model.DAO;

import model.BEAN.Department;
import model.BEAN.Staff;
import model.BEAN.User;

public class Check {
	public static void main(String[] args) {
		DepartmentDAO staffDao = new DepartmentDAO();
//		for (Staff staff : staffDao.findByIdDepartment(1)) {
//			System.out.println(staff.toString());
//		}
		System.out.println(staffDao.findById(1));
	}
}
