package model.BO;

import java.util.ArrayList;

import model.BEAN.Department;
import model.DAO.DepartmentDAO;

public class DepartmentBO {
	private DepartmentDAO departmentDAO = new DepartmentDAO();
	public DepartmentBO() {
		
	}
	public ArrayList<Department> getAll() {
		return departmentDAO.getAll();
	}
	public void updateDepartment(Department department) {
		departmentDAO.updateDepartment(department);
	}
	public void addDepartment(Department department) {
		departmentDAO.addDepartment(department);
	}
	public void deleteUser(int idDepartment) {
		departmentDAO.deleteUser(idDepartment);
	}
	public Department findById(int idDepartment) {
		return departmentDAO.findById(idDepartment);
	}
	public ArrayList<Department> findByName(String nameDepartment) {
		return departmentDAO.findByName(nameDepartment);
	}
}
