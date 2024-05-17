package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.LimitExceededException;

import model.BEAN.User;

public class UserDAO {
	private Connection conn;
	public UserDAO() {
		try {
			this.conn = JDBCUtils.getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public boolean isValidUser ( String username , String password) {
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
	public ArrayList<User> getAll(){
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
            listUsers.add(user);
        }
        return listUsers;
	}
	
}
