package model.BO;

import java.util.ArrayList;

import model.BEAN.Staff;
import model.DAO.StaffDao;

public class StaffBO {
	private StaffDao staffDAO = new StaffDao();
	public StaffBO() {
		
	}
	public ArrayList<Staff> getAll() {
		return staffDAO.getAll();
	}
	public void updateStaff(Staff staff) {
		staffDAO.updateStaff(staff);
	}
	public void addStaff(Staff staff) {
		staffDAO.addStaff(staff);
	}
	public void deleteStaff(int idStaff) {
		staffDAO.deleteStaff(idStaff);
	}
	public Staff findById(int idStaff) {
		return staffDAO.findById(idStaff);
	}
	public ArrayList<Staff> findByName(String nameStaff) {
		return staffDAO.findByName(nameStaff);
	}
	public ArrayList<Staff> findByIdDepartment(int idDepartment) {
		return staffDAO.findByIdDepartment(idDepartment);
	}
}
