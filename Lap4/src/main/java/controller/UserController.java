package controller;

import java.util.ArrayList;

import model.BEAN.User;
import model.BO.UserBO;
import model.DAO.UserDAO;

public class UserController {
	private UserBO userBO = new UserBO();
	public UserController() {}
	public boolean isValidUser (String username, String password) {
		return userBO.isValidUser(username, password);
	}
	public ArrayList<User> getAll() {
		return userBO.getAll();
	}
	public void updateUser(User user) {
		userBO.updateUser(user);
	}
	public void addUser(User user) {
		userBO.addUser(user);
	}
	public void deleteUser(int idUser) {
		userBO.deleteUser(idUser);
	}
	public User findById(int idUser) {
		return userBO.findById(idUser);
	}
}
