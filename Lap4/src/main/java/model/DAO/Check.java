package model.DAO;

import model.BEAN.Department;
import model.BEAN.Staff;
import model.BEAN.User;

public class Check {
	public static void main(String[] args) {
		DepartmentDAO staffDao = new DepartmentDAO();
		for (Department staff : staffDao.getAll()) {
			System.out.println(staff.toString());
		}
	}
}
