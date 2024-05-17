package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BEAN.Department;
import model.BEAN.Staff;
import model.BEAN.User;

public class DepartmentDAO {
	private Connection conn;

	public DepartmentDAO() {
		try {
			this.conn = JDBCUtils.getConnection();
//			System.err.println(conn.toString()); 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<Department> getAll() {
		try {
			String sql = "SELECT * FROM department";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Department> listDepartment = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Department department = new Department(name, description);
				department.setId(id);
				listDepartment.add(department);
			}
			return listDepartment;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void updateDepartment(Department department) {
		try {
			String sql = "UPDATE department SET name = ?, description = ? WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, department.getName());
			statement.setString(2, department.getDescription());
			statement.setInt(3, department.getId());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Record updated successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void addDepartment(Department department) {
		try {
			String sql = "INSERT INTO department (name, description) VALUES (?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, department.getName());
			stmt.setString(2, department.getDescription());

			// Bước 5: Thực hiện câu lệnh SQL INSERT INTO
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Dữ liệu đã được chèn vào bảng Department thành công!");
			} else {
				System.out.println("Không có dữ liệu nào được chèn.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void deleteUser(int idDepartment) {
		try {
			String sql = "DELETE FROM department WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idDepartment);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Department deleted successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public Department findById(int idDepartment) {
		try {
			String sql = "SELECT * FROM department WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idDepartment);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Department department = new Department(name, description);
				department.setId(id);
				return department;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList<Department> findByName(String nameDepartment) {
		try {
			ArrayList<Department> listDepartment = new ArrayList<>();
			String query = "SELECT * FROM department WHERE name LIKE ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			// Use the LIKE operator with wildcard characters
			preparedStatement.setString(1, "%" + nameDepartment + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Department department = new Department(name, description);
				department.setId(id);
				listDepartment.add(department);
			}
			return listDepartment;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;

	}
}
