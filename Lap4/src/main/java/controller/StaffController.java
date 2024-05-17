package controller;

import java.util.ArrayList;

import model.BEAN.Staff;
import model.BO.StaffBO;
import model.DAO.StaffDao;

public class StaffController {
	private StaffBO staffBO = new StaffBO();
	public StaffController() {
		
	}
	public ArrayList<Staff> getAll() {
		return staffBO.getAll();
	}
	public void updateStaff(Staff staff) {
		staffBO.updateStaff(staff);
	}
	public void addStaff(Staff staff) {
		staffBO.addStaff(staff);
	}
	public void deleteStaff(int idStaff) {
		staffBO.deleteStaff(idStaff);
	}
	public Staff findById(int idStaff) {
		return staffBO.findById(idStaff);
	}
	public ArrayList<Staff> findByName(String nameStaff) {
		return staffBO.findByName(nameStaff);
	}
	public ArrayList<Staff> findByIdDepartment(int idDepartment) {
		return staffBO.findByIdDepartment(idDepartment);
	}
}
