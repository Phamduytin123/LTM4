package controller;

import java.util.ArrayList;

import model.BEAN.Department;
import model.BO.DepartmentBO;
import model.DAO.DepartmentDAO;

public class DepartmentController {
	private DepartmentBO departmentBO = new DepartmentBO();
	public DepartmentController() {
		
	}
	public ArrayList<Department> getAll() {
		return departmentBO.getAll();
	}
	public void updateDepartment(Department department) {
		departmentBO.updateDepartment(department);
	}
	public void addDepartment(Department department) {
		departmentBO.addDepartment(department);
	}
	public void deleteUser(int idDepartment) {
		departmentBO.deleteDepartment(idDepartment);
	}
	public Department findById(int idDepartment) {
		return departmentBO.findById(idDepartment);
	}
	public ArrayList<Department> findByName(String nameDepartment) {
		return departmentBO.findByName(nameDepartment);
	}
}
