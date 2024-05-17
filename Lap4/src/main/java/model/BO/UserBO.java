package model.BO;

import java.util.ArrayList;

import model.BEAN.User;
import model.DAO.UserDAO;

public class UserBO {
	private UserDAO userDAO = new UserDAO();
	public UserBO() {}
	public boolean isValidUser (String username, String password) {
		return userDAO.isValidUser(username, password);
	}
	public ArrayList<User> getAll() {
		return userDAO.getAll();
	}
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	public void deleteUser(int idUser) {
		userDAO.deleteUser(idUser);
	}
	public User findById(int idUser) {
		return userDAO.findById(idUser);
	}
}
