package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BEAN.Staff;
import model.BEAN.User;

public class StaffDao {
	private Connection conn;

	public StaffDao() {
		try {
			this.conn = JDBCUtils.getConnection();
//			System.err.println(conn.toString()); 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<Staff> getAll() {
		try {
			String sql = "SELECT * FROM staff";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Staff> listStaff = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idDepartment = resultSet.getInt("idDepartment");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");
				Staff staff = new Staff(idDepartment, name, address, gender, phone);
				staff.setId(id);
				listStaff.add(staff);
			}
			return listStaff;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void updateStaff(Staff staff) {
		try {
			String sql = "UPDATE staff SET idDepartment = ?, name = ?, address = ?, gender = ?, phone = ? WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, staff.getIdDepartment());
			statement.setString(2, staff.getName());
			statement.setString(3, staff.getAddress());
			statement.setString(4, staff.getGender());
			statement.setString(5, staff.getPhone());
			statement.setInt(6, staff.getId());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Staff updated successfully!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void addStaff(Staff staff) {
		try {
			String sql = "INSERT INTO staff (idDepartment, name, address, gender, phone) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, staff.getIdDepartment());
			statement.setString(2, staff.getName());
			statement.setString(3, staff.getAddress());
			statement.setString(4, staff.getGender());
			statement.setString(5, staff.getPhone());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void deleteStaff(int idStaff) {
		try {
			String sql = "DELETE FROM staff WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idStaff);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Staff deleted successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public Staff findById(int idStaff) {
		try {
			String sql = "SELECT * FROM staff WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idStaff);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idDepartment = resultSet.getInt("idDepartment");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");
				Staff staff = new Staff(idDepartment, name, address, gender, phone);
				staff.setId(id);
				return staff;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<Staff> findByName(String nameStaff) {
		try {
			ArrayList<Staff> listStaff = new ArrayList<>();
			String query = "SELECT * FROM staff WHERE name LIKE ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			// Use the LIKE operator with wildcard characters
			preparedStatement.setString(1, "%" + nameStaff + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idDepartment = resultSet.getInt("idDepartment");
				String foundName = resultSet.getString("name");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");

				Staff staff = new Staff(idDepartment, foundName, address, gender, phone);
				staff.setId(id);
				listStaff.add(staff);
			}
			return listStaff;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;

	}

	public ArrayList<Staff> findByIdDepartment(int idDepartment) {
		try {
			String sql = "SELECT * FROM staff WHERE idDepartment =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idDepartment);
			System.out.println(idDepartment);
			ResultSet resultSet = statement.executeQuery();

			ArrayList<Staff> listStaff = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");

				Staff staff = new Staff(idDepartment, name, address, gender, phone);
				staff.setId(id);
				listStaff.add(staff);
			}
			return listStaff;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
}
