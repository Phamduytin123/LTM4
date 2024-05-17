package model.BEAN;

public class User {
	private int id;
	private String username;
	private String password;
	private Integer idInfor;
	public User() {
		
	}
	public User(String username, String password, Integer idInfor) {
		super();
		this.username = username;
		this.password = password;
		this.idInfor = idInfor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdInfor() {
		return idInfor;
	}
	public void setIdInfor(Integer idInfor) {
		this.idInfor = idInfor;
	}
	
}
