package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.relation.Relation;
import javax.naming.LimitExceededException;

import model.BEAN.User;

public class UserDAO {
	private Connection conn;

	public UserDAO() {
		try {
			this.conn = JDBCUtils.getConnection();
//			System.err.println(conn.toString()); 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String username, String password) {
		try {
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Người dùng đã được tìm thấy
				return true;
			} else {
				// Người dùng không tồn tại
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<User> getAll() {
		try {
			String sql = "SELECT * FROM user";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ArrayList<User> listUsers = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				int idInfor = resultSet.getInt("idInfor");
				User user = new User(username, password, idInfor);
				user.setId(id);
				listUsers.add(user);
			}
			return listUsers;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void updateUser(User user) {
		try {
			String sql = "UPDATE user SET username = ?, password = ?, idInfor = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getIdInfor());
			statement.setInt(4, user.getId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("User updated successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void addUser(User user) {
		try {
			String sql = "INSERT INTO user (username, password, idInfor) VALUES (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, (int) user.getIdInfor());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void deleteUser(int idUser) {
		try {
			String sql = "DELETE FROM user WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idUser);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("User deleted successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public User findById(int idUser) {
		try {
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idUser);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				int idInfor = resultSet.getInt("idInfor");
				User user = new User(username, password, idInfor);
				user.setId(id);
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	public User findUser(String username, String password) {
		try {
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Người dùng đã được tìm thấy
				User user = new User(resultSet.getString("username"),resultSet.getString("password"),resultSet.getInt("idInfor"));
				user.setId(resultSet.getInt("id"));
				return user;
			} else {
				// Người dùng không tồn tại
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public User findByIdInfor(int idInfor) {
		try {
			String sql = "SELECT * FROM user WHERE idInfor = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idInfor);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Người dùng đã được tìm thấy
				User user = new User(resultSet.getString("username"),resultSet.getString("password"),resultSet.getInt("idInfor"));
				user.setId(resultSet.getInt("id"));
				return user;
			} else {
				// Người dùng không tồn tại
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
